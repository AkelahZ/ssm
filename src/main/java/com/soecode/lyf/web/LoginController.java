package com.soecode.lyf.web;

/**
 * Created by Administrator on 2018/4/10.
 *
 * @author ZLC
 */
import com.soecode.lyf.entity.Role_Result;
import com.soecode.lyf.entity.User;
import com.soecode.lyf.entity.User_Result;
import com.soecode.lyf.service.RoleService;
import com.soecode.lyf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/login") // url:/模块/资源/{id}/细分 /seckill/list
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @RequestMapping("/commit")
    public ModelAndView loginpage(User user,HttpSession session){
        ModelAndView mav;
        if(userService.isUserCorrect(user.getAccount(),user.getPassword())==1){
            mav= new ModelAndView("homepage");
            User_Result uR=userService.getByPandA(user.getAccount(),user.getPassword());
            List<Role_Result> list=roleService.getAllById(uR.getRoleId());

            session.setAttribute("user",uR);
            List<Integer> listp=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                    listp.add(list.get(i).getPowerId());
            }
            session.setAttribute("userPower",listp);
            session.setAttribute("userPowerName",list);
        }

        else{
            mav= new ModelAndView("redirect:/index");
            session.setAttribute("login",0);

        }

        return mav;
    }

}
