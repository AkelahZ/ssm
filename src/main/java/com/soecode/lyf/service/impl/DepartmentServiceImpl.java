package com.soecode.lyf.service.impl;

import com.soecode.lyf.IDao.DepartmentDao;
import com.soecode.lyf.entity.Department;
import com.soecode.lyf.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 *
 * @author ZLC
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
@Autowired
    DepartmentDao departmentDao;

    @Override
    public int insertDepartment(Department department) {
        return departmentDao.insertSelective(department);
    }

    @Override
    public List<Department> selectAll() {
        return departmentDao.selectAll();
    }

    @Override
    public Department selectByPK(Integer departmentId) {
        return departmentDao.selectByPrimaryKey(departmentId);
    }

    @Override
    public int deleteByPK(Integer departmentId) {
        return departmentDao.deleteByPrimaryKey(departmentId);
    }

    @Override
    public int update(Department department) {
        return departmentDao.updateByPrimaryKeySelective(department);
    }
}
