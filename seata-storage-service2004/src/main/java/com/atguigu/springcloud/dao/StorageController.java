package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StorageController {
    void decrease(@Param("productId") Long productId,@Param("count") Integer count );

    Storage get();
}
