package com.soecode.lyf.IDao;

import com.soecode.lyf.entity.Order_Result;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Order_ResultDao {
    List<Order_Result> selectAll();
}