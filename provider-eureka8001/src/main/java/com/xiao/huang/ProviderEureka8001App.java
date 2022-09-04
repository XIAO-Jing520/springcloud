package com.xiao.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xiaosulun
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderEureka8001App {
    public static void main(String[] args) {
        SpringApplication.run(ProviderEureka8001App.class);
    }
}
