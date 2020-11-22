package com.atguigu.cloud.feign.Iml;

import com.atguigu.cloud.feign.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceIml implements PaymentService {
    @Override
    public CommonResult<Payment> payMentSQL(Long id) {
        return new CommonResult<>(444,"全局兜底",null);
    }
}
