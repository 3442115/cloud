package com.atguigu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class EchoController {

// 不可用

//    @Value("${service-url.nacos-user-service}")
    private static final String PAYMENT_URL="http://nacos-payment-provider";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback")
    private CommonResult<Payment> fallBack(@PathVariable("id")Long id){
        System.out.println(restTemplate);
        CommonResult<Payment> objectCommonResult = restTemplate.getForObject(PAYMENT_URL+"/payMentSQL/"+id,CommonResult.class,id);

       if (id == 4){
           throw new IllegalArgumentException("非法参数异常！");
       }else if (objectCommonResult.getData() == null){
           throw new NullPointerException("空指针异常！");
       }
    return objectCommonResult;

    }


}
