package com.soecode.lyf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/4/10.
 *
 * @author ZLC
 */
@Controller
@RequestMapping("/resource") // url:/模块/资源/{id}/细分 /seckill/list
public class ResourceController {
    @RequestMapping("/recieve")
    public String recieve(){

        return "resource_recieve";
    }

    @RequestMapping("/rend")
    public String rend(){

        return "resource_rend";
    }

    @RequestMapping("/rend_exam_list")
    public String rend_exam_list(){

        return "rend_exam_list";
    }
    @RequestMapping("/rend_exam_detail")
    public String rend_exam_detail(){

        return "rend_exam_detail";
    }
}
