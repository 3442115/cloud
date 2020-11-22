package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PayMentServiceIml.PayMentServieIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
     public Object getMessge(){
         List<String> services = discoveryClient.getServices();
         for (String service : services) {
             System.out.println("getServices-------"+service);
         }
         System.out.println();
//         List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//         for (ServiceInstance instance : instances) {
//             //log.info("getInstances------"+instance);
//         }
         return discoveryClient;
     }

     //进行  路由
    @GetMapping(value = "/payment/lb")
    public String getPaymentLb(){
        return serverPort;
    }


     @GetMapping(value = "/payment/timeout")
    public String getTimeout(){
         try {
             TimeUnit.SECONDS.sleep(3);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         return serverPort;
     }

    @GetMapping(value = "/payment/zipkin")
    public String PaymentZipKin(){

        return "hi,i am paymentzipkin;";
    }

}
