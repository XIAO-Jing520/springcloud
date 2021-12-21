package xiao.com.huang;

import com.xiao.bean.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xiao.com.huang.bean.Storage;
import xiao.com.huang.service.StorageService;

import javax.annotation.Resource;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-22 2:10
 * @Version : 1.0
 **/
@RestController
public class ControllerStorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(Storage storage){

        storageService.decrease(storage);

        return new CommonResult(200,"库存减少成功");
    }
}
