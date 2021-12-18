package com.xiao.huang.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiao.bean.CommonResult;

/**
 * @Author Milo
 * @Description
 * @Date 2020-05-15 09:37
 **/
public class CustomerBlockHandler
{
    public static CommonResult handlerException(BlockException exception)
    {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }
    public static CommonResult handlerException2(BlockException exception)
    {
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }
}
