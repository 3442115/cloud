package com.atguigu.springcloud.filter;

import com.netflix.ribbon.proxy.annotation.Http;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.util.logging.Logger;

@Component
@Slf4j
public class MyGloableFilter implements GlobalFilter, Ordered {

Logger logger=null;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String username = exchange.getRequest().getQueryParams().getFirst("username");
                                             //做的工作就是 只有判断是否含有自己定义的过滤条件即可
        if(username == null){
            logger.info("=========用户名为null =========");

            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
      return  chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
