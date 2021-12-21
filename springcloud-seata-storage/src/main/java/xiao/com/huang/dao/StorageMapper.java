package xiao.com.huang.dao;

import org.apache.ibatis.annotations.Mapper;
import xiao.com.huang.bean.Storage;

@Mapper
public interface StorageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
}