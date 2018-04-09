package com.soecode.lyf.web;

/**
 * Created by Administrator on 2018/4/10.
 *
 * @author ZLC
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("") // url:/模块/资源/{id}/细分 /seckill/list
public class IndexController {
    @RequestMapping("/index")
    public String homepage(Model model){
        model.addAttribute("indexMsg", "hello,this is a.jsp form homepage/index.do");
        System.out.println("this is homepage!!!");
        return "a";
    }
}
