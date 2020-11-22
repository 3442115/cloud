package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainConsumer84 {
    public static void main(String[ ] args) {
        SpringApplication.run(MainConsumer84.class,args);
    }
}
