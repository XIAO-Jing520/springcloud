package com.com.xiao.controller;

import com.xiao.bean.CommonResult;
import com.xiao.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2022-08-31 23:53
 * @Version : 1.0
 **/
@RestController
@Slf4j
public class ControllerConsumer {


    @Resource
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    //大写，必须和eureka 上的名字一致
    String url="http://127.0.0.1:8001";

    @PostMapping("/payment/create")
    public CommonResult create (@RequestBody Payment payment){

        log.info("端口： "+port);
        return restTemplate.postForObject(url+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable Integer id){

        log.info("端口： "+port);
        return restTemplate.getForObject(url+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/discovery")
    public List<String> discovery(){

        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);
        return services;
    }

}
