package com.positive.countrylibrary.controller;

import com.positive.countrylibrary.service.HomeConfigService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.positive.countrylibrary.bean.HomeCofig;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.controller
 * @filename PageController
 * @data 2023/3/5
 * @description TODO
 */
@Controller//不能用RestController，RestController直接返回的是内容
public class PageController {
    @Resource
    private HomeConfigService homeConfigService;
    @RequestMapping("/config/home")
    public String getHomePage(Model model){
        List<HomeCofig> list = homeConfigService.findAll();
        model.addAttribute("configs",list);
        return "homeconfig";
    }
}
