package xiao.com.huang.service;

import org.springframework.stereotype.Service;
import xiao.com.huang.bean.Account;
import xiao.com.huang.dao.AccountMapper;
import xiao.com.huang.service.AccountService;

import javax.annotation.Resource;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-22 23:20
 * @Version : 1.0
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;
    @Override
    public void cost(Long userId,Long money) {
        accountMapper.cost( userId,money);
    }

    @Override
    public Account select(Account account) {
        return accountMapper.selectByPrimaryKey(account.getId());
    }
}
