package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PayMentFeignService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PayMentFeignController {
    @Resource
    private PayMentFeignService payMentFeignService;

    @GetMapping(value = "/consumer/payment/getpayment/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){

        return payMentFeignService.getPayment(id);
    }
    @PostMapping(value = "/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return payMentFeignService.create(payment);
    }
    @GetMapping(value = "/consumer/payment/timeout")
    public String getTimeout(){
        return payMentFeignService.getTimeout();
    }
}
