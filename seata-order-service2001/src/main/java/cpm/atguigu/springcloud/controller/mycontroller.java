package cpm.atguigu.springcloud.controller;

import cpm.atguigu.springcloud.domain.CommonResult;
import cpm.atguigu.springcloud.domain.Order;
import cpm.atguigu.springcloud.service.AccountService;
import cpm.atguigu.springcloud.service.OrderService;
import cpm.atguigu.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class mycontroller {

    @Resource
    private OrderService orderService;
    @Resource
    private AccountService accountService;


    @GetMapping("/ssss")
    public CommonResult set(Order order){
       orderService.createOrder(order);
       return new CommonResult(200,"创建成功！",order);
    }
    // 测试能否调通 2002 微服务
    @GetMapping("/sss")
    public void get(){
    accountService.get();
    }


}
