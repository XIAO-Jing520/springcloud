package com.xiao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
//@RibbonClient(name = "PROVIDER-ORDER-EUREKA",configuration = Rule.class)
public class ConsumerFeign82 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign82.class);
    }

}
