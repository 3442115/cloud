package com.atguigu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

 @GetMapping("/testA")
    public String testA(){


     return "-------testA";
 }
    @GetMapping("/testB")
    public String testB(){
        return "-------testB";
    }
    @GetMapping("/testD")
    public String testD(){
         int a=10/0;
        return "-------testD";
    }
    @GetMapping("/testE")
    @SentinelResource(value = "testE",blockHandler = "deal_method")
    public String setHotKey(@RequestParam(value = "p1",required = false) String p1,
                            @RequestParam(value = "p2",required = false) String p2){

     return "hot ---- key";
    }
    public String deal_method(String p1, String p2, BlockException blockException){
     return "这是兜底方法！！！！！";
    }

}
