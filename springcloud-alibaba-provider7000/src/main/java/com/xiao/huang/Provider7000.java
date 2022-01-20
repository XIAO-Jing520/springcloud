package com.xiao.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootApplication
@EnableDiscoveryClient
public class Provider7000 {



    public static void main(String[] args) {
        SpringApplication.run(Provider7000.class);


    }

}
