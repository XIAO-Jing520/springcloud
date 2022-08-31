package com.com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 * @author xiaosulun
 */

@EnableEurekaClient
@SpringBootApplication
public class ConsumerEurekaApp
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext run = SpringApplication.run(ConsumerEurekaApp.class);

        String[] beanDefinitionNames = run.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionNames = " + beanDefinitionName);
        }

    }
}
