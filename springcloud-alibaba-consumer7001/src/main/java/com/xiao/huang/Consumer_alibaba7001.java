package com.xiao.huang;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
//@RibbonClient(name = "PROVIDER-ORDER-EUREKA",configuration = Rule.class)
public class Consumer_alibaba7001 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_alibaba7001.class);
    }

}
