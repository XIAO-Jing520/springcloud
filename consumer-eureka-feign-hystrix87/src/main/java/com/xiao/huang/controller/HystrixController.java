package com.xiao.huang.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiao.bean.CommonResult;
import com.xiao.huang.service.HystrixTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-01 4:39
 * @Version : 1.0
 **/
@RestController
@Slf4j

//这是一个全局的服务降级使用  但是需要在使用服务降级的方法放个注解 @HystrixCommand
/*@DefaultProperties(defaultFallback = "timeoutHandler",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
})*/


//配合使用在业务层的服务降级 //设置超时时长
//@DefaultProperties(commandProperties = {
//        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//})
public class HystrixController {

    @Resource
    HystrixTestService hystrixTestService;


    //execution.isolation.thread.timeoutInMilliseconds  也可以放在配置文件 作为全局使用，在这里单独接口使用
    //并且这是一个单独使用的服务降级，可以全局配置在controller 类加注解
//    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })

  //  @HystrixCommand
    @GetMapping("/payment/timeout")
    public String timeout() {

        return hystrixTestService.timeout();
    }

    //服务降级方法
    public String timeoutHandler() {

        return "这个是消费者服务降级方法";
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Integer id) {

        return hystrixTestService.get(id);
    }
}
