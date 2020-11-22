package cpm.atguigu.springcloud.service;

import cpm.atguigu.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping(value = "/storage/decrease")
    void decrease(@RequestParam("productId") Long productId,@RequestParam("count")  Integer count );

    @GetMapping("/ss")
    public void get();
}
