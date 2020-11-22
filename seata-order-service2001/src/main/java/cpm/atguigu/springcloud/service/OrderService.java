package cpm.atguigu.springcloud.service;

import cpm.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderService {
    void createOrder(Order order);

    void update(@Param("userId")Long userId, @Param("status")Integer status);

    Order get();
}
