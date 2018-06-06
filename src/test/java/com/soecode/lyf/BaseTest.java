package com.soecode.lyf;

import com.soecode.lyf.IDao.OrderDao;
import com.soecode.lyf.IDao.UserDao;
import com.soecode.lyf.IDao.User_ResultDao;
import com.soecode.lyf.entity.Order;
import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class BaseTest {
    @Resource
    UserDao userDao;
    @Resource
    OrderDao orderDao;
    @Test
    public void test1(){
        Order order=new Order();
        order.setOrderType(1);
        order.setOrderStatus(1);
        order.setDepartmentId(1);
        order.setOperatorId(7);
        orderDao.insertSelective(order);
    }
}
