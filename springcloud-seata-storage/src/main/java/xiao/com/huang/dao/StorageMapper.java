package xiao.com.huang.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xiao.com.huang.bean.Storage;

@Mapper
public interface StorageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Storage record);

    void decrease(@Param("productId") Long productId, @Param("amounts") Integer amounts);

    int updateByPrimaryKey(Storage record);
}