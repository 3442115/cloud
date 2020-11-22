package com.atguigu.cloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap=new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"123154321654231645"));
        hashMap.put(2L,new Payment(2L,"784561646161265465"));
        hashMap.put(3L,new Payment(3L,"78892+329652561651"));
    }

    @GetMapping("/payMentSQL/{id}")
    public CommonResult<Payment> payMentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> commonResult=new CommonResult<>(200,"from sql "+ serverPort,payment);
        return commonResult;
    }

}
