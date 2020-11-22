package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PayMentController {
    @Value("${server.port}")
    private String serverport;

    @RequestMapping(value = "/payment/consul")
    public String paymentcs(){

        return  "springcloud with consul:"+serverport+"\t"+ UUID.randomUUID().toString();
    }
}
