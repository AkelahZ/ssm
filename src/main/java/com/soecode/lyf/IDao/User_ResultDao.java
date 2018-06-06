package com.soecode.lyf.IDao;


import com.soecode.lyf.entity.User_Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User_ResultDao {
    User_Result selectByPrimaryKey(Integer userId);
    List<User_Result> selectAll();
    User_Result selectByPandA(@Param("account")String account, @Param("password")String password);
}