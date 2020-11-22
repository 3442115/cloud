package com.atguigu.springcloud.service.serviceIml;

import com.atguigu.springcloud.dao.AccountDao;
import com.atguigu.springcloud.domain.Account;
import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountServiceIml implements AccountService {
@Resource
private AccountDao accountDao;
    @Override
    public Account get() {
        return accountDao.get();
    }

    @Override
    public void decrease(Long userId, BigDecimal money) {
         accountDao.decrease(userId,money);
    }
}
