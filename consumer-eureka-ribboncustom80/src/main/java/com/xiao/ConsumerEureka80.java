package com.xiao;


import com.rule.Rule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
//@RibbonClient(name = "PROVIDER-ORDER-EUREKA",configuration = Rule.class)
public class ConsumerEureka80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerEureka80.class);
    }

    @Bean
//    @LoadBalanced      //注解赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}