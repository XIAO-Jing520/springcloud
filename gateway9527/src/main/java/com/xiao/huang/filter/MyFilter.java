package com.xiao.huang.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-07 2:10
 * @Version : 1.0
 **/
@Component
public class MyFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String id = exchange.getRequest().getQueryParams().getFirst("id");

        if (Integer.parseInt(id)<3) {

//            System.out.println("太小-----------id = " + id);

            System.out.println("---------------------------------");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }


    //级别
    @Override
    public int getOrder() {
        return 0;
    }
}
