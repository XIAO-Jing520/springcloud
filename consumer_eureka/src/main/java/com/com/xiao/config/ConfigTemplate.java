package com.com.xiao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2022-09-01 0:33
 * @Version : 1.0
 **/
@Configuration
public class ConfigTemplate {

    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}
