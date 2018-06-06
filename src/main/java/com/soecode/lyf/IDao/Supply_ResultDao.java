package com.soecode.lyf.IDao;


import com.soecode.lyf.entity.Supply;
import com.soecode.lyf.entity.Supply_Result;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Supply_ResultDao {
    Supply_Result selectAllByPrimaryKey(Integer supplyId);


    List<Supply_Result> selectAll();
}