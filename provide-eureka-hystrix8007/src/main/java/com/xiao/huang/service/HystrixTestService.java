package com.xiao.huang.service;

import cn.hutool.core.lang.UUID;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Description : 服务降级条件 1. 程序运行异常，2. 超时，3.服务熔断触发，4.线程池、信号量打满
 *
 * 一般服务降级在客户端实现
 * @Author : 肖苏伦
 * @Date : 2021-12-01 4:09
 * @Version : 1.0
 **/

@Service
public class HystrixTestService {
//    execution.isolation.thread.timeoutInMilliseconds   超过多长时间未响应 调用 hystrix 服务降级
//    @HystrixCommand(fallbackMethod ="timeoutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
//    })
    //服务降级基本都在客户端
    public String timeout() {

        String RandomID = UUID.randomUUID().toString();

        int i=10/0;
        System.out.println("i = " + i);
        int time = 1;
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池 " + Thread.currentThread().getName() + "      超时响应，延迟  " + time + " 毫秒 " + "uuid ：" + RandomID;
    }


    public String timeoutHandler(){

        return "启用了服务降级程序------";
    }


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", //兜底方法
            commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){

        if (id<0){
            throw new RuntimeException("不能为负数");
        }
        return "线程池 " + Thread.currentThread().getName() +    "  uuid ："  + id ;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){

        return "服务熔断--------";
    }


}
