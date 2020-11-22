package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.Account;
import com.atguigu.springcloud.domain.CommonResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Mapper
@Repository
public interface AccountDao {

    Account get();

    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money );
}
