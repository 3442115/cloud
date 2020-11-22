package com.atguigu.cloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

public class CustomerHandlerBlockException {


    public static CommonResult handlerException(BlockException e){
        return new CommonResult(404,e.getClass().getCanonicalName(),null);
    }
    public static CommonResult handlerException2(BlockException e){
        return new CommonResult(404,e.getClass().getCanonicalName()+"------------------2",null);
    }
}
