package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
//@Repository 这个注解再插入时有时候会有问题  这个注解和@Autowired一块使用
public interface PayMentDao {
    public int create(Payment payment);
    public Payment getPayment(@Param("id") Long id);
}
