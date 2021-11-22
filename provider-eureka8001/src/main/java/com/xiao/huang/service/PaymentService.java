package com.xiao.huang.service;


import com.xiao.bean.Payment;

public interface PaymentService {
    public String createPayment(Payment payment);
    public Payment getPayment(Integer id);
}
