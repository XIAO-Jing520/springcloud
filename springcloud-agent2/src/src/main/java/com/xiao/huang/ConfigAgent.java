package com.xiao.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-08 1:38
 * @Version : 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
public class ConfigAgent {
    public static void main(String[] args) {
        SpringApplication.run(ConfigAgent.class);
    }
}
