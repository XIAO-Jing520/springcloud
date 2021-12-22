package xiao.com.huang.service;

import com.xiao.bean.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient("seata-account-service")
public interface AccountService {
    @PostMapping("/account/cost")
    public CommonResult cost(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}