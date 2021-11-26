package com.xiao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class ConsumerEureka80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerEureka80.class);
    }

    @Bean
    @LoadBalanced      //注解赋予RestTemplate负载均衡的能力
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
