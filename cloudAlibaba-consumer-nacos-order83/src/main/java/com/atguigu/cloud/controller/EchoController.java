package com.atguigu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloud.feign.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class EchoController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private PaymentService paymentService;


  private static final String PAYMENT="http://nacos-payment-provider";

    @GetMapping(value = "/consumer/echo/string/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback",fallback = "handlerback") //fallback只负责业务异常
    @SentinelResource(value = "fall",blockHandler = "blockHandler",
    exceptionsToIgnore = {IllegalArgumentException.class}) // 只负责控制台配置违规
    public CommonResult<Payment> echo(@PathVariable("id") Long id) {
        CommonResult<Payment> result=
                restTemplate.getForObject(PAYMENT+"/payMentSQL/"+id,CommonResult.class,id);
      if (id == 4){
           throw new IllegalArgumentException("参数不合法！");
       }else if (id == null){
          throw new NullPointerException("空参数！");
            }
           return result;

        }
// public CommonResult handlerback(@PathVariable("id")Integer id,Throwable e){
//        return new CommonResult(404,"兜底方法！",null);
// }
public CommonResult blockHandler(@PathVariable("id") Long id,BlockException blockException){
    Payment payment = new Payment(404L, "block兜底！");
    return new CommonResult<>(404,"兜底blockHandler",payment);
}

@GetMapping("/consumer/order/{id}")
    public CommonResult Consumer(@PathVariable("id") Long id){
    CommonResult<Payment> commonResult = paymentService.payMentSQL(id);
    return commonResult;

}

}
