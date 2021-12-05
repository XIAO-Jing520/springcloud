package com.xiao.huang.service;

import com.xiao.bean.Payment;
import com.xiao.huang.dao.PaymentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDao paymentDao;

    @Override
    public String createPayment(Payment payment) {



        paymentDao.createPayment(payment);


        System.out.println("生成的主键为： " + payment.getId());
        return "插入成功"+payment.getId();
    }

    @Override
    public Payment getPayment(Integer id) {
        return paymentDao.getPayment(id);
    }
}
