package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PayMentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class Paymentcontroller {
    @Resource
    private PayMentService payMentService;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment/hystrix/ok/{id}")
    public String getString(@PathVariable("id") Integer id){
        String result=payMentService.getString(id);
        System.out.println(result);
        return  result;
    }

    @GetMapping("/payment/timeout/{id}")
    public String getTimeout(@PathVariable("id") Integer id){
        String result=payMentService.getString2(id);
        System.out.println(result);
        return  result;
    }

    //==============服务熔断=============
    @GetMapping("/payment/circuit/{id}")
    public String payMentCircuitBreaker(@PathVariable("id")Integer id){
        System.out.println(payMentService.payMentCircuitBreaker(id));
        return payMentService.payMentCircuitBreaker(id);
    }
}
