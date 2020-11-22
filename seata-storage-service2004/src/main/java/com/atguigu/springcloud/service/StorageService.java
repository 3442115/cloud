package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Storage;
import org.apache.ibatis.annotations.Param;

public interface StorageService {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count) ;

    Storage get();
}
