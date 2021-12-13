package com.xiao.huang.controller;

import com.xiao.bean.CommonResult;
import com.xiao.bean.Payment;

import com.xiao.huang.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* @program: ${PROJECT_NAME}
* @description: 使用Feign接口调用远程服务的方法时，定义各参数绑定，@PathVariable、@RequestParam、@RequestHeader等可以指定参数属性，
 *              在Feign中绑定参数必须通过value属性来明确指明具体的参数名，不然会抛出异常。
* @author: 肖苏伦
* @create: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
**/
@RestController
@Slf4j
public class ConsumerController {

    @Resource
    private PaymentService paymentService;

    //获取端口号
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment) {

        log.info("端口-----------------------serverPort = " + serverPort);
        return paymentService.create(payment);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Integer id) {

        log.info("端口-----------------------serverPort = " + serverPort);
        return paymentService.get(id);
    }

    @GetMapping("/payment/timeout")
    public String timeout(){
       return paymentService.timeout();
    }
}
