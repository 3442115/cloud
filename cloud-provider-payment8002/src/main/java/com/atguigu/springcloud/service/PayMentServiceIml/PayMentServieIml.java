package com.atguigu.springcloud.service.PayMentServiceIml;

import com.atguigu.springcloud.dao.PayMentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PayMentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayMentServieIml implements PayMentService {
    @Resource
   private PayMentDao payMentDao;
     @Override
    public int create(Payment payment) {
        return payMentDao.create(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return payMentDao.getPayment(id);
    }
}
