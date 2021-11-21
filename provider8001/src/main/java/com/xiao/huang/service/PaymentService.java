package com.xiao.huang.service;


import com.xiao.bean.Payment;

import javax.annotation.Resource;

public interface PaymentService {
    public String createPayment(Payment payment);
    public Payment getPayment(Integer id);
}
