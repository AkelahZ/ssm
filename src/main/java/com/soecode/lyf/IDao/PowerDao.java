package com.soecode.lyf.IDao;

import com.soecode.lyf.entity.Power;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerDao {
    int deleteByPrimaryKey(Integer powerId);

    int insert(Power record);

    int insertSelective(Power record);

    Power selectByPrimaryKey(Integer powerId);

    int updateByPrimaryKeySelective(Power record);

    int updateByPrimaryKey(Power record);

    List<Power> selectAll();
}