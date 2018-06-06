package com.soecode.lyf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/4/10.
 *
 * @author ZLC
 */
@Controller
@RequestMapping("/rend") // url:/模块/资源/{id}/细分 /seckill/list
public class RendController {
    @RequestMapping("/revert_detail")
    public String revert_detail(){

        return "rend_revert_detail";
    }

    @RequestMapping("/revert_list")
    public String revert_list(){

        return "rend_revert_list";
    }
}
