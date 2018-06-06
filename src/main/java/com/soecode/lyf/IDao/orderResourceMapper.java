package com.soecode.lyf.IDao;

import com.soecode.lyf.entity.orderResource;

public interface orderResourceMapper {
    int deleteByPrimaryKey(Integer orderResourceId);

    int insert(orderResource record);

    int insertSelective(orderResource record);

    orderResource selectByPrimaryKey(Integer orderResourceId);

    int updateByPrimaryKeySelective(orderResource record);

    int updateByPrimaryKey(orderResource record);
}