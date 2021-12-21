package xiao.com.huang.service;

import xiao.com.huang.bean.Order;
import xiao.com.huang.dao.OrderMapper;

import javax.annotation.Resource;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-22 1:39
 * @Version : 1.0
 **/
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    public void create(Order order) {

        orderMapper.insert(order);

        storageService.decreaseStorage();

        accountService.decreaseAccount();

        order.setStatus(1);
        orderMapper.updateByPrimaryKey(order);

    }
}
