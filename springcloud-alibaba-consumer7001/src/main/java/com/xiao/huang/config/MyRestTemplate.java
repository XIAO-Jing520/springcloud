package com.xiao.huang.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-11-29 1:48
 * @Version : 1.0
 **/
@Configuration
public class MyRestTemplate {
    @Bean
    @LoadBalanced      //注解赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
