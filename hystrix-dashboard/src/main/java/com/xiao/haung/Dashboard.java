package com.xiao.haung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-02 1:25
 * @Version : 1.0
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class Dashboard {

    public static void main(String[] args) {
        SpringApplication.run(Dashboard.class);
    }
}
