package com.atguigu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @Value("${server.port}")
    private int serverPort;

    @GetMapping(value = "/echo/string/{id}")
    public String echo(@PathVariable("id") Integer id) {
        return "Hello Nacos Discovery " + serverPort+"  id is :"+id;
    }
}
