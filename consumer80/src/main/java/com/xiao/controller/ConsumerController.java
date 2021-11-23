package com.xiao.controller;

import com.xiao.bean.CommonResult;
import com.xiao.bean.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    public static String URL="http://127.0.0.1:8001";

    @PostMapping("/payment/create")
    public CommonResult create (Payment payment){

        return restTemplate.postForObject(URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable Integer id){
        return restTemplate.getForObject(URL+"/payment/get/"+id,CommonResult.class);
    }
}
