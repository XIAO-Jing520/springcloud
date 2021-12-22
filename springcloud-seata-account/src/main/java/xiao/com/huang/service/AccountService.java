package xiao.com.huang.service;

import xiao.com.huang.bean.Account;

public interface AccountService {
    void cost(Long userId,Long money);
    Account select(Account account);
}
