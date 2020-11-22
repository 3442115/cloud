package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateConfig {
@Bean
    public RouteLocator getRou(RouteLocatorBuilder routeLocatorBuilder){
    RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
    routes.route("path_route_atguigu",
            r->r.path("/guonei") //访问9527的guonei意思就是  转到下面的那个uri
                    .uri("http://news.baidu.com/guonei")).build();
    return routes.build();
}

}
