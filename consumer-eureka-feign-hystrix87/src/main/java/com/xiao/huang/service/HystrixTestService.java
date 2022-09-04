package com.xiao.huang.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiao.bean.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description :默认情况下,openFiegn在进行服务调用时,要求服务提供方处理业务逻辑时间必须在1S内返回,如果超过1S没有返回则
 * OpenFeign会直接报错,不会等待服务执行,但是往往在处理复杂业务逻辑是可能会超过1S,因此需要修改OpenFeign的默认服务调用超时时间。
 * @Author : 肖苏伦
 * @Date : 2021-12-01 4:26
 * @Version : 1.0
 **/
@Component
//@FeignClient(value = "PROVIDER-ORDER-EUREKA")
@FeignClient(value = "PROVIDER-ORDER-EUREKA", fallback = HystrixTestServiceImpl.class)  //业务层使用服务降级，进行代码解耦
public interface HystrixTestService {


    @GetMapping("/payment/timeout")
    public String timeout();

    @GetMapping("/payment/get/{id}")
    CommonResult get(@PathVariable("id") Integer id);

}
