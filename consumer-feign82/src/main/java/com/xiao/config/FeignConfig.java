package com.xiao.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-11-29 2:04
 * @Version : 1.0
 **/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level config() {

        return Logger.Level.FULL;
    }
}
