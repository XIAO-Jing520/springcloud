package com.xiao.huang.controller;

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
public class HystrixController {

    @Resource
    HystrixTestService hystrixTestService;

    @GetMapping("/payment/timeout")
    public String timeout(){

        return  hystrixTestService.timeout();
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Integer id) {

        return hystrixTestService.get(id);
    }
}
