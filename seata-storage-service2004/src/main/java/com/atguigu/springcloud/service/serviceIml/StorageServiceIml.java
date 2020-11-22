package com.atguigu.springcloud.service.serviceIml;

import com.atguigu.springcloud.dao.StorageController;
import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Storage;
import com.atguigu.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceIml implements StorageService {
    @Resource
    private StorageController storageController;
    @Override
    public void decrease(Long productId, Integer count) {
       storageController.decrease(productId,count);

    }

    @Override
    public Storage get() {
     return storageController.get();
    }
}
