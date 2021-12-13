package com.xiao.huang.service;

import com.xiao.bean.CommonResult;
import com.xiao.bean.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-11-29 1:49
 * @Version : 1.0
 **/
@FeignClient(value = "consumer-alibaba-provider7000")
@Component
public interface PaymentService {

    @PostMapping("/payment/create")
    CommonResult create(Payment payment);

    @GetMapping("/payment/get/{id}")
    CommonResult get(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout")
    String timeout();

}
