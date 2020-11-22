package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PayMentServiceIml.PayMentServieIml;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/*
* 调用方法 插入和查询 数据
* */

@RestController
public class PayMentController {
    @Autowired
    private PayMentServieIml payMentServiceIml;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
      int result=payMentServiceIml.create(payment);

     if(result>0){
         return new CommonResult(200,"插入数据库成功---serverPort:"+serverPort,result);
     }else{
         return new CommonResult(200,"插入数据库失败---",result);
     }
    }
    @GetMapping(value = "/payment/getpayment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
      Payment result=payMentServiceIml.getPayment(id);

        if(result!=null){
            return new CommonResult(200,"查询成功---serverPort:"+serverPort,result);
        }else{
            int waa=10/2;

            return new CommonResult(444,"查询失败---，id是："+id,result);
        }
     }
     @GetMapping(value = "/payment/discovery")
     public Object getMessage(){
         List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
         for (ServiceInstance instance : instances) {
             System.out.println(instance.getHost()+instance.getServiceId()+instance.getInstanceId());
         }
         return this.discoveryClient;
     }
    //进行  路由
    @GetMapping(value = "/payment/lb")
    public String getPaymentLb(){
        return serverPort;
    }

}
