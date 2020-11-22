package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@RestController
public class AccountController {
    @Resource
    private AccountService accountService;
    @PostMapping(value = "/account/decrease")
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money ){
   try {
       TimeUnit.SECONDS.sleep(30);
   } catch (InterruptedException e) {
       e.printStackTrace();
   }
        accountService.decrease(userId,money);
    }
    @GetMapping("/ss")
    public void get(){
        System.out.println(accountService.get());
    }
}
