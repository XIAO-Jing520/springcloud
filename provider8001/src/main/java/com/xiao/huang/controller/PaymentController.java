package com.xiao.huang.controller;


import com.xiao.bean.CommonResult;
import com.xiao.bean.Payment;
import com.xiao.huang.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {


    @Resource
    private PaymentService paymentService;

    //增加
    //获取端口号
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){



        String s=paymentService.createPayment(payment);

        System.out.println("s = " + s);

        return new CommonResult(200,"插入成功 ， 端口为 ："+serverPort,s);
    }

    @GetMapping("/payment/get")
    public String success(){
        return "成功";
    }

}
