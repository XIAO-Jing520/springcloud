package com.xiao.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-01 4:27
 * @Version : 1.0
 **/
@EnableHystrix
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class APP {
    public static void main(String[] args) {
        SpringApplication.run(APP.class);
    }
}
