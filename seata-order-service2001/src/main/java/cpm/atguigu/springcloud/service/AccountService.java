package cpm.atguigu.springcloud.service;

import cpm.atguigu.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/decrease")
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money );

    @GetMapping("/ss")
    public void get();
}
