package com.soecode.lyf.service.impl;

import com.soecode.lyf.IDao.ResourceDao;
import com.soecode.lyf.entity.Resource;
import com.soecode.lyf.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 *
 * @author ZLC
 */
@Service
public class ResourceServiceImpl implements ResourceService{
    @Autowired
    ResourceDao resourceDao;

    @Override
    public List<Resource> selectAll() {
        return resourceDao.selectAll();
    }

    @Override
    public int update(Resource resource) {
        return resourceDao.updateByPrimaryKeySelective(resource);
    }

    @Override
    public int delete(Integer resourceId) {
        return resourceDao.deleteByPrimaryKey(resourceId);
    }

    @Override
    public int insertResource(Resource resource) {
        return resourceDao.insertSelective(resource);
    }

    @Override
    public Resource selectByPK(Integer resourceId) {
        return resourceDao.selectByPrimaryKey(resourceId);
    }
}
