package com.xiao.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  //启用hystrix熔断
public class ProviderEureka8007App {
    public static void main(String[] args) {
        SpringApplication.run(ProviderEureka8007App.class);
    }
}
