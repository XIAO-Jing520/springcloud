package com.xiao.huang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-15 23:58
 * @Version : 1.0
 **/

@Controller
public class Test {

    @RequestMapping("/testA")
    public String testA(){

        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("new Date() = " + new Date().toString());

        System.out.println("A---dcssssssssssssssssss");
        return "aaa";
    }
//    @GetMapping("/testB")
//    public String testB(){
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
//        return "testB-----------";
//    }
//    @GetMapping("/testC")
//    public String testC(){
//
//        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
//        return "testC-----------";
//    }
    @RequestMapping("/testD")
    public String testD(){


//        try {
//            request.getRequestDispatcher("/testA").forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("DDDDDDDDDDDDDDD");
        return "forward:/testA";

    }

}
