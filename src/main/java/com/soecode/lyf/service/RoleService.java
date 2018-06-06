package com.soecode.lyf.service;

import com.soecode.lyf.entity.Role;
import com.soecode.lyf.entity.Role_Result;
import com.soecode.lyf.entity.rolePower;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/5/22.
 *
 * @author ZLC
 */
public interface RoleService {
    List<Role_Result> getAll();

    List<Role_Result> getAllById(int role_Id);

    List<Role> selectAll();

    int update(Role role);

    int delete(Integer roleId);

    int insertRole(Role role);

    int insertRP(rolePower rolePower);

    Role selectByPK(Integer role_id);
}
