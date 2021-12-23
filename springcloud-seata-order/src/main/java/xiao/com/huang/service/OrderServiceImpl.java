package xiao.com.huang.service;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import xiao.com.huang.bean.Order;
import xiao.com.huang.dao.OrderMapper;

import javax.annotation.Resource;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-22 1:39
 * @Version : 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        System.out.println("order.toString() = " + order.toString());
        orderMapper.insert(order);
        System.out.println("订单创建完成-------");
        System.out.println("库存减少------------");
        storageService.decrease(order.getProductId(), order.getCount());
        System.out.println("库存减少-------");
        System.out.println("账户金额减少-------");
        accountService.cost(order.getUserId(), order.getMoney());
        System.out.println("账户金额减少完成-------");

        System.out.println("所有模块完成service-------");
        Order order1 = new Order();
        order1.setId(order.getId());
        order1.setStatus(1);
        orderMapper.updateByPrimaryKeySelective(order1);

    }
}
