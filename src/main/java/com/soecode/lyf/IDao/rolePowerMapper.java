package com.soecode.lyf.IDao;

import com.soecode.lyf.entity.rolePower;

public interface rolePowerMapper {
    int deleteByPrimaryKey(Integer rolePowerId);

    int insert(rolePower record);

    int insertSelective(rolePower record);

    rolePower selectByPrimaryKey(Integer rolePowerId);

    int updateByPrimaryKeySelective(rolePower record);

    int updateByPrimaryKey(rolePower record);
}