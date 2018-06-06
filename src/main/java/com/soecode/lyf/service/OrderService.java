package com.soecode.lyf.service;

import com.soecode.lyf.entity.Order;
import com.soecode.lyf.entity.Order_Result;
import com.soecode.lyf.entity.Power;
import com.soecode.lyf.entity.orderResource;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 *
 * @author ZLC
 */
public interface OrderService {
    List<Order> selectAll();

    List<Order> selectAllByType(String orderType);

    int update(Order order);
    int delete(Integer orderId);
    int insert(Order order);
    List<Order_Result> selectAllOrderRes();

    int insertOR(orderResource or);
}
