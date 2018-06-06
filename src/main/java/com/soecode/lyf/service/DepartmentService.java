package com.soecode.lyf.service;

import com.soecode.lyf.entity.Department;
import com.soecode.lyf.entity.Product;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 *
 * @author ZLC
 */
public interface DepartmentService {
    int insertDepartment(Department department);
    List<Department> selectAll();
    Department selectByPK(Integer departmentId);

    int deleteByPK(Integer departmentId);

    int update(Department department);
}
