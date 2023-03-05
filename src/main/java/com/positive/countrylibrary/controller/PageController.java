package com.positive.countrylibrary.controller;

import com.alibaba.fastjson.JSONObject;
import com.positive.countrylibrary.service.HomeConfigService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.positive.countrylibrary.bean.HomeCofig;
import com.positive.countrylibrary.util.StringTool;

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
    @RequestMapping(value = "update", method = {RequestMethod.POST })
    public JSONObject update(@RequestBody HomeCofig cofig){
        JSONObject object = new JSONObject();
        HomeCofig config = homeConfigService.findById(cofig.getId());
        if (config !=  null){
            if (!StringTool.isEmpty(cofig.getImageurl())) {
                config.setImageurl(cofig.getImageurl());
            }
            if (!StringTool.isEmpty(cofig.getUrl())) {
                config.setUrl(cofig.getUrl());
            }
            if (!StringTool.isEmpty(cofig.getTitle())) {
                config.setTitle(cofig.getTitle());
            }
            config.setExtra(cofig.getExtra());
            homeConfigService.update(config);
            object.put("status","success");
        }
        else{
            object.put("status","no find");
        }

        return object;
    }
}
