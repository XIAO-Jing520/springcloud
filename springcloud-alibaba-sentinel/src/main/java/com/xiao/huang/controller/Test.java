package com.xiao.huang.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-15 23:58
 * @Version : 1.0
 **/

@RestController
//@Controller
public class Test {

    @RequestMapping("/testA")
    public String testA() {

        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("new Date() = " + new Date().toString());

        System.out.println("A---dcssssssssssssssssss");
//        return "redirect:aaa.html";
        return "testA-----------";
    }

    @GetMapping("/testB")
    public String testB() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        return "testB-----------";
    }

    @GetMapping("/testC")
    public String testC() {

        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        return "testC-----------";
    }

    //实现处理函数，该函数的传参必须与资源点的传参一样，并且最后加上BlockException异常参数；同时，返回类型也必须一样。否则不生效！！！！
    @GetMapping("/testD")
//    @SentinelResource(value = "hot", blockHandler = "blockHandlerD", fallback = "fallbackD")
    @SentinelResource(value = "hot", fallback = "fallbackD")
    public String testD(@RequestParam(required = false, value = "a") String a,
                        @RequestParam(required = false, value = "b") String b) {


        if (a.equals("1")) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (a.isEmpty()) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }

//        try {
//            request.getRequestDispatcher("/testA").forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("DDDDDDDDDDDDDDD");
//        return "forward:/testA";

        return "testD--------------";
    }

    //fallback  是针对于 java 异常情况的，但是假如加了流控的话，首先进入流控的blockHander 方法，并不会进入fallback 方法
    public String fallbackD(@RequestParam(required = false, value = "a") String a,
                            @RequestParam(required = false, value = "b") String b) {

        return "这是个fallback 方法--------------------------";
    }

    public String blockHandlerD(@RequestParam(required = false, value = "a") String a,
                                @RequestParam(required = false, value = "b") String b,
                                BlockException blockedException) {

        return "这个是自定义blockHandlerD-----------------" + a;
    }


    @RequestMapping("/hotkey")
    public String hotKey(@RequestParam(required = false,value = "a") String a,@RequestParam(required = false,value = "b") String b){


        return "hot key";
    }

}
