package com.xiao.huang.controller;


import com.xiao.bean.CommonResult;
import com.xiao.bean.Payment;
import com.xiao.huang.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public CommonResult<Payment> create(@RequestBody Payment payment){



        String s=paymentService.createPayment(payment);

        System.out.println("s = " + s);

        return new CommonResult(200,"插入成功 ， 端口为 ："+serverPort,s);
    }

    @GetMapping("/payment/get/{id}")
    public String success(@PathVariable Integer id){



        Payment payment=paymentService.getPayment(id);



        return "成功";
    }

}
