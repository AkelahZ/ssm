package com.soecode.lyf.service.impl;

import com.soecode.lyf.IDao.UserDao;
import com.soecode.lyf.IDao.User_ResultDao;
import com.soecode.lyf.IDao.userRoleMapper;
import com.soecode.lyf.entity.Role;
import com.soecode.lyf.entity.User;
import com.soecode.lyf.entity.User_Result;
import com.soecode.lyf.entity.userRole;
import com.soecode.lyf.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/10.
 *
 * @author ZLC
 */
@Service
public class UserServiceImpl implements UserService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private UserDao userDao;
    @Autowired
    private User_ResultDao user_resultDao;
    @Autowired
    private userRoleMapper userRoleMapper;
    @Override
    public int isUserCorrect(String account, String password) {
       if(userDao.selectByPandA(account,password)!=null){
           return 1;
       }
       else
           return 0;
    }

    @Override
    public User_Result getByPandA(String account, String password) {
        return user_resultDao.selectByPandA(account,password);
    }

    @Override
    public List<User> getuserAll() {
        return userDao.selectAll();
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUser(Integer userId) {
        return userDao.deleteByPrimaryKey(userId);
    }

    @Override
    public List<userRole> getAllUserRole(Integer userId){
        return userRoleMapper.getAllUserRole(userId);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertSelective(user);
    }

    @Override
    public int insertUserRole(userRole userRole) {
        return userRoleMapper.insertSelective(userRole);
    }

    @Override
    public User getUserByPK(Integer user_id) {
        return userDao.selectByPrimaryKey(user_id);
    }
}
