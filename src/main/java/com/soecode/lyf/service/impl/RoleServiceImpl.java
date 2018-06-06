package com.soecode.lyf.service.impl;

import com.soecode.lyf.IDao.RoleDao;
import com.soecode.lyf.IDao.Role_ResultDao;
import com.soecode.lyf.IDao.User_ResultDao;
import com.soecode.lyf.IDao.rolePowerMapper;
import com.soecode.lyf.entity.Role;
import com.soecode.lyf.entity.Role_Result;
import com.soecode.lyf.entity.rolePower;
import com.soecode.lyf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/5/22.
 *
 * @author ZLC
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private Role_ResultDao role_resultDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private rolePowerMapper rolePowerMapper;
    @Override
    public List<Role_Result> getAll() {
        return role_resultDao.selectAll();
    }

    @Override
    public List<Role_Result> getAllById(int role_Id) {
        return role_resultDao.getAllById(role_Id);
    }

    @Override
    public List<Role> selectAll() {
        return roleDao.selectAll();
    }

    @Override
    public int update(Role role) {
        return roleDao.updateByPrimaryKeySelective(role);
    }

    @Override
    public int delete(Integer roleId) {
        return roleDao.deleteByPrimaryKey(roleId);
    }

    @Override
    public int insertRole(Role role) {
        return roleDao.insertSelective(role);
    }

    @Override
    public int insertRP(rolePower rolePower) {
        return rolePowerMapper.insertSelective(rolePower);
    }

    @Override
    public Role selectByPK(Integer role_id) {
        return roleDao.selectByPrimaryKey(role_id);
    }
}
