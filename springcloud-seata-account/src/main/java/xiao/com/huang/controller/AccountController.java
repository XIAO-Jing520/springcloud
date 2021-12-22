package xiao.com.huang.controller;

import com.xiao.bean.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xiao.com.huang.bean.Account;
import xiao.com.huang.service.AccountService;

import javax.annotation.Resource;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-22 23:10
 * @Version : 1.0
 **/
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account/cost")
    public CommonResult cost(@RequestParam("userId") Long userId, @RequestParam("money") Long money){

        accountService.cost( userId, money);

        return new CommonResult(200,"扣钱成功");
    }
}
