package com.soecode.lyf.IDao;


import com.soecode.lyf.entity.Role_Result;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface Role_ResultDao {
    List<Role_Result> selectAll();

    List<Role_Result> getAllById(int role_id);
}