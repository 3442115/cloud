package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class OrderFallbackservice implements OrderService{
    @Override
    public String getString(Integer id) {
        return "----Fallback method is getString 正常执行出现异常！";
    }

    @Override
    public String getTimeout(Integer id) {
        return "----Fallback method is getTimeout 超时异常！";
    }
}
