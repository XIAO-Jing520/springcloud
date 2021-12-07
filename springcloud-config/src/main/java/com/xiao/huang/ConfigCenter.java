package com.xiao.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-08 0:55
 * @Version : 1.0
 **/
@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class ConfigCenter {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter.class);
    }
}
