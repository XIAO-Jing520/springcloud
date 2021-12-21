package xiao.com.huang.controller;

import com.xiao.bean.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xiao.com.huang.bean.Order;
import xiao.com.huang.service.OrderServiceImpl;

import javax.annotation.Resource;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-22 1:36
 * @Version : 1.0
 **/
@RestController
public class OrderController {



    @Resource
    private OrderServiceImpl orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){

        orderService.create(order);

        return new CommonResult(200,"创建成功");

    }
}
