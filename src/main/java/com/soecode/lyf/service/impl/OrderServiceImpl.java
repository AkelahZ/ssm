package com.soecode.lyf.service.impl;

import com.soecode.lyf.IDao.OrderDao;
import com.soecode.lyf.IDao.Order_ResultDao;
import com.soecode.lyf.IDao.orderResourceMapper;
import com.soecode.lyf.entity.Order;
import com.soecode.lyf.entity.Order_Result;
import com.soecode.lyf.entity.orderResource;
import com.soecode.lyf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 *
 * @author ZLC
 */
@Service
public class OrderServiceImpl implements OrderService {
@Autowired
    OrderDao orderDao;
@Autowired
    Order_ResultDao order_resultDao;
@Autowired
    orderResourceMapper orderResourceMapper;
    @Override
    public List<Order> selectAll() {
        return orderDao.selectAll();
    }

    @Override
    public List<Order> selectAllByType(String orderType) {
        return orderDao.selectAllByType();
    }

    @Override
    public int update(Order order) {
        return orderDao.updateByPrimaryKeySelective(order);
    }

    @Override
    public int delete(Integer orderId) {
        return orderDao.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(Order order) {
        return orderDao.insertSelective(order);
    }

    @Override
    public List<Order_Result> selectAllOrderRes() {
        return order_resultDao.selectAll();
    }

    @Override
    public int insertOR(orderResource or) {
        return orderResourceMapper.insertSelective(or);
    }
}
