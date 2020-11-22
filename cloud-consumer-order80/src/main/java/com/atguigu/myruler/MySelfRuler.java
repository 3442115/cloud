package com.atguigu.myruler;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MySelfRuler {
    @Bean
    public IRule getRule(){
        //自定义自己的负载规则
        return new RandomRule();
    }
}
