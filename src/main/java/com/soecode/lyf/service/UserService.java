package com.soecode.lyf.service;

import com.soecode.lyf.entity.User;
import com.soecode.lyf.entity.User_Result;
import com.soecode.lyf.entity.userRole;

import java.util.List;

/**
 * Created by Administrator on 2018/4/10.
 *
 * @author ZLC
 */
public interface UserService {
    /**
     * 确定用户是否存在
     *
     * @param account
     * @param password
     * @return
     */
    int isUserCorrect(String account,String password);

    User_Result getByPandA(String account, String password);

    List<User> getuserAll();

    int updateUser(User user);

    int deleteUser(Integer userId);

    List<userRole> getAllUserRole(Integer userId);

    int insertUser(User user);

    int insertUserRole(userRole userRole);

    User getUserByPK(Integer user_id);
}
