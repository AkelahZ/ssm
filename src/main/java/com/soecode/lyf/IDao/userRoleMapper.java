package com.soecode.lyf.IDao;

import com.soecode.lyf.entity.userRole;

import java.util.List;

public interface userRoleMapper {
    int deleteByPrimaryKey(Integer userRoleId);

    int insert(userRole record);

    int insertSelective(userRole record);

    userRole selectByPrimaryKey(Integer userRoleId);

    int updateByPrimaryKeySelective(userRole record);

    int updateByPrimaryKey(userRole record);

    List<userRole> getAllUserRole(Integer userId);


}