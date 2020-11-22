package cpm.atguigu.springcloud.dao;

import cpm.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderDao {
  void createOrder(Order order);

  void update(@Param("userId")Long userId,@Param("status")Integer status);

  Order get();
}
