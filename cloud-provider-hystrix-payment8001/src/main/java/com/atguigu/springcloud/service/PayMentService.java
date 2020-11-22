package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PayMentService {
    //=======================服务降级部分==========================
    //能正常访问的方法
    public String getString(Integer is){
        return "肯定能正常访问的了!"+"        "+is;
    }
    //消耗3秒

    @HystrixCommand(fallbackMethod = "getString2FallBack" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds" ,value="5000")
    })
    public String getString2(Integer id){

        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "需要消耗时间才能运行完成，消耗的时间是+"+"      ";
    }
    //降级方法
    public String getString2FallBack(Integer id){
        return "超时了呢！系统报错  ┭┮﹏┭┮";
    }


    //=======================服务熔断部分==========================
    @HystrixCommand(fallbackMethod = "payMentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"), // 是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"), //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"), //时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60"), //失败率达到多少 后跳闸
                                                                                //在十秒内  失败率达到60% 就会跳闸
    })
    public  String payMentCircuitBreaker(@PathVariable("id") Integer id){
       if(id<0){
           throw new RuntimeException("id不能为负数！");
       }
       String uuid= IdUtil.simpleUUID();
       return Thread.currentThread().getName()+"调用成功"+"      "+uuid;
    }

    public String payMentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试~~~~id:"+id;
    }


}
