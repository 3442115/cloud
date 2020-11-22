package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Account;
import com.atguigu.springcloud.domain.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface AccountService {
    Account get();

   void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money );
}
