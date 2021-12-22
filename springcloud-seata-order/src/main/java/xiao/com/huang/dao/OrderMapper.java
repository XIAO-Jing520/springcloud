package xiao.com.huang.dao;

import org.apache.ibatis.annotations.Mapper;
import xiao.com.huang.bean.Order;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}