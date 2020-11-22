package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/*调用另外一个module模块*/

@RestController
@Slf4j
public class OrderController {
    //private static final String PAYMENT_URL="http://localhost:8001";
 private static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";


   @Resource
    private RestTemplate restTemplate;
  @GetMapping(value = "/consumer/payment/create")
   public CommonResult<Payment> creat(Payment payment){

       return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
   }


   @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
      return restTemplate.getForObject(PAYMENT_URL+"/payment/getpayment/"+id,CommonResult.class);
                                            //记得斜杠   斜杠    斜杠  /////
   }
   //getForEntity 更详细
    @GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> get2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getpayment/" + id, CommonResult.class);
   if (forEntity.getStatusCode().is2xxSuccessful()){
       return forEntity.getBody();
   }else{
       return new CommonResult<Payment>(444,"操作失败",null);
   }
    }

    @GetMapping(value = "/consumer/payment/zipkin")
    public String consumerZipKin(){
      String re=restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/",String.class);
      return re;
    }
}
