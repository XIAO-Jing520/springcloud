package com.xiao.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient  //分布式服务基本都需要，除了eureka
@SpringBootApplication
public class ProviderConsulApp {
    public static void main(String[] args) {
        SpringApplication.run(ProviderConsulApp.class);
    }
}
