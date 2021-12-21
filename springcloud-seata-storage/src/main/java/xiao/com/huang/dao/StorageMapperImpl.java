package xiao.com.huang.dao;

import org.apache.ibatis.annotations.Mapper;
import xiao.com.huang.bean.Storage;

/**
 * @Description : TODO
 * @Author : 肖苏伦
 * @Date : 2021-12-22 2:09
 * @Version : 1.0
 **/

public class StorageMapperImpl implements StorageMapper{
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(Storage record) {
        return 0;
    }

    @Override
    public int insertSelective(Storage record) {
        return 0;
    }

    @Override
    public Storage selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Storage record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Storage record) {
        return 0;
    }
}
