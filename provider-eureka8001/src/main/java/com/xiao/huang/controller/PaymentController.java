package com.xiao.huang.controller;


import com.xiao.bean.CommonResult;
import com.xiao.bean.Payment;
import com.xiao.huang.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PaymentController {

    @Resource
    DiscoveryClient discoveryClient;

    @Resource
    private PaymentService paymentService;

    //增加
    //获取端口号
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/discovery")
    public Object discovery(){

        //获取注册时的服务名
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            System.out.println("service = " + service);
        }
        //
        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-ORDER-EUREKA");

        for (ServiceInstance instance : instances) {
            System.out.println("instance.getHost() = " + instance.getHost());
            System.out.println("instance.getMetadata() = " + instance.getMetadata());
            System.out.println("instance.getPort() = " + instance.getPort());
            System.out.println("-------------------------------------");
        }

        return null;
    }

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {

        String s = paymentService.createPayment(payment);
        System.out.println("s = " + s);
        return new CommonResult(200, "插入成功 ， 端口为 ：" + serverPort, s);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult success(@PathVariable Integer id) {

        Payment payment = paymentService.getPayment(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功,端口为： " + serverPort, payment);
        }
        return new CommonResult(404, "查询失败,端口为： " + serverPort, "没有 id 记录");
    }
    //自定义负载均衡算法

    @GetMapping("/payment/lb")
    public String myLoadB(){
        return  "serverPort = " + serverPort;
    }

}
