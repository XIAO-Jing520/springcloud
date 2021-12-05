package com.xiao.huang.service;

import com.xiao.bean.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-01 23:56
 * @Version : 1.0
 **/
@Component
public class HystrixTestServiceImpl implements HystrixTestService{
    @Override
    public String timeout() {
        return "进入 timeout 方法服务降级---------------";
    }

    @Override
    public CommonResult get(Integer id) {
        return new CommonResult(555,"服务降级方法",null);
    }
}
