package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "gloable_TimeOut")
public class OrderHystrixController {
    @Resource
    private OrderService orderService;
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String getString(@PathVariable("id") Integer id){
      return   orderService.getString(12);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "getTime_OutFallBack" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
//    @HystrixCommand   全局时   需要注明
    public String getTimeout(@PathVariable("id") Integer id){
        return orderService.getTimeout(id);
    }

    public String getTime_OutFallBack(@PathVariable("id") Integer id){
        return "系统超市了哦！   ┭┮﹏┭┮+┭┮﹏┭┮";
    }
    public String gloable_TimeOut(){
        return "这次是全局的 Gloable系统是真的超时了了哦！   3*┭┮﹏┭┮+┭┮﹏┭┮";
    }

}
