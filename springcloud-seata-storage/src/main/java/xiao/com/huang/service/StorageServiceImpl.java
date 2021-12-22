package xiao.com.huang.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import xiao.com.huang.bean.Storage;
import xiao.com.huang.dao.StorageMapper;

import javax.annotation.Resource;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-22 2:20
 * @Version : 1.0
 **/
@Service
public class StorageServiceImpl implements StorageService{

    @Resource
    StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer amounts) {
        storageMapper.decrease(productId,  amounts);
    }
}
