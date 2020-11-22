package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private StorageService storageService;
    @GetMapping("/ss")
    public void get(){
        System.out.println(storageService.get());
    }


    @PostMapping(value = "/storage/decrease")
    void decrease(@RequestParam("productId") Long productId,@RequestParam("count")  Integer count ){

      storageService.decrease(productId,count);

    }

}
