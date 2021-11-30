package com.xiao.huang.service;

import cn.hutool.core.lang.UUID;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description : 服务降级条件 1. 程序运行异常，2. 超时，3.服务熔断触发，4.线程池、信号量打满
 * @Author : 肖苏伦
 * @Date : 2021-12-01 4:09
 * @Version : 1.0
 **/

@Service
public class HystrixTestService {

//    @HystrixCommand(fallbackMethod ="timeoutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
//    })
    //服务降级基本都在客户端
    public String timeout() {

        String RandomID = UUID.randomUUID().toString();

//        int i=10/0;
        int time = 3000;
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


}
