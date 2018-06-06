package com.soecode.lyf.web;

import com.soecode.lyf.entity.*;
import com.soecode.lyf.service.OrderService;
import com.soecode.lyf.service.ProductService;
import com.soecode.lyf.service.ResourceService;
import com.soecode.lyf.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/4/10.
 *
 * @author ZLC
 */
@Controller
@RequestMapping("/order") // url:/模块/资源/{id}/细分 /seckill/list
public class OrderController {

    @Autowired
    ProductService productService;
    @Autowired
    SupplyService supplyService;
    @Autowired
    ResourceService resourceService;
    @Autowired
    OrderService orderService;
    @RequestMapping("/order_create")
    public String order_Crearte(HttpServletRequest request){
        List<Supply_Result> products=supplyService.getAllsupplyProduct();
        request.setAttribute("products",products);
        return "order_create";
    }

    @RequestMapping(value = "/order_create/commit" ,produces={"text/html;charset=UTF-8;","application/json;"})
    public String order_Crearte_commit(String[] projectId,Integer[] buy_num,HttpServletRequest request,HttpSession session){
        User_Result op= (User_Result) session.getAttribute("user");
        Order order=new Order();
        order.setDepartmentId(op.getUserDepartment());
        order.setOperatorId(op.getUserId());
        order.setOrderStatus(1);//未通过审核
        order.setOrderType(1);//采购单
        orderService.insert(order);
        for (int i=0;i<projectId.length;i++) {
            String s=projectId[i];
            String[] a=s.split("#");
            Integer productId=Integer.parseInt(a[0]);
            Integer supplyId=Integer.parseInt(a[1]);
            for(int j=0;j<buy_num[i];j++){
                Resource resource=new Resource();
                resource.setProductId(productId);
                resource.setResourceType("0");
                resource.setSupplyId(supplyId);
                resourceService.insertResource(resource);
                orderResource or=new orderResource();
                or.setOrderId(order.getOrderId());
                or.setResourceId(resource.getResourceId());
                orderService.insertOR(or);
            }

        }
        List<Supply_Result> products=supplyService.getAllsupplyProduct();
        request.setAttribute("products",products);
        return "order_create";
    }
    @RequestMapping("/order_exam_list")
    public String order_exam_List(){

        return "order_exam_list";
    }

    @RequestMapping("/order_exam_detail")
    public String order_exam_Detail(){

        return "order_exam_detail";
    }
}
