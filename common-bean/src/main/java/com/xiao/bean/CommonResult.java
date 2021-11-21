package com.xiao.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {


    private Integer Code;
    private String message;
    private T data;
    //假如数据为空的情况
    public CommonResult(Integer code,String message){

        this(code, message,null);
    }
}
