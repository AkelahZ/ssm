package com.soecode.lyf.service;

import com.soecode.lyf.entity.Resource;
import com.soecode.lyf.entity.Role;
import com.soecode.lyf.entity.Role_Result;
import com.soecode.lyf.entity.rolePower;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 *
 * @author ZLC
 */
public interface ResourceService {


    List<Resource> selectAll();



    int update(Resource resource);

    int delete(Integer resourceId);

    int insertResource(Resource resource);

    Resource selectByPK(Integer resourceId);
}
