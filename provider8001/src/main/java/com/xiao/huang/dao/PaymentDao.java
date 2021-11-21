package com.xiao.huang.dao;

import com.xiao.bean.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface PaymentDao {

    public Integer createPayment(Payment payment);

    public Payment  getPayment(@Param("id") Integer id);


}
