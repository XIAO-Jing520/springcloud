package com.xiao.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description :
 * @Author : 肖苏伦
 * @Date : 2021-12-15 23:49
 * @Version : 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelRun {
    public static void main(String[] args) {
        SpringApplication.run(SentinelRun.class);
    }
}
