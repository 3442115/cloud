package com.atguigu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloud.myhandler.CustomerHandlerBlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value ="byResource",blockHandler = "handlerException")
    public CommonResult byResource(){

        return new CommonResult(200,"按资源名称限流测试",new Payment(2020L,"serial001"));
    }

     public CommonResult handlerException(BlockException e){
        return new CommonResult(400,e.getClass().getCanonicalName(),null);
     }

    @GetMapping("/byCustomerBlock/abc")
    @SentinelResource(value ="byCustomerBlock",blockHandlerClass = CustomerHandlerBlockException.class,
                                                blockHandler = "handlerException2")
    public CommonResult CustomerBlock(){

        return new CommonResult(200,"按客户自定义进行测试",new Payment(2020L,"serial001"));
    }
}
