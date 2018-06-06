package com.soecode.lyf.IDao;


import com.soecode.lyf.entity.Supply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyDao {
    int deleteByPrimaryKey(Integer supplyId);

    int insert(Supply record);

    int insertSelective(Supply record);

    Supply selectByPrimaryKey(Integer supplyId);

    List<Supply> selectAll();

    int updateByPrimaryKeySelective(Supply record);

    int updateByPrimaryKey(Supply record);
}