package com.xiao.huang.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-07 1:05
 * @Version : 1.0
 **/
@Configuration
public class MyGatewayConfig {

    @Bean
    public RouteLocator customUrl(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        //访问 localhost:9527 + /lady  将转发到 https://news.baidu.com/lady
        return routes.route("id1",(r -> r.path("/lady").uri("https://news.baidu.com"))).build();


    }
}
