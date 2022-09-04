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
@RibbonClient(name = "PROVIDER-ORDER-EUREKA",configuration = Rule.class)
public class ConsumerEureka81 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerEureka81.class);
    }

    @Bean
    @LoadBalanced      //注解赋予RestTemplate负载均衡的能力(若生产者为集群，必须加上，不加这个注解可能会找不到哪一个服务)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
