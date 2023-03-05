package com.positive.countrylibrary.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.positive.countrylibrary.bean.HomeCofig;
import com.positive.countrylibrary.service.HomeConfigService;
import com.positive.countrylibrary.service.UserService;
import com.positive.countrylibrary.util.StringTool;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.controller
 * @filename HomeConfigureController
 * @data 2023/3/4
 * @description 首页配置
 */

@RestController
@RequestMapping("/config")
public class HomeConfigureController {
    @Resource
    private HomeConfigService homeConfigService;

    @GetMapping("/homeget")
    public JSONObject getContent(){
        JSONObject object = new JSONObject();
        List<HomeCofig> configs = homeConfigService.findAll();
        object.put("status","success");
        if (configs != null){
            JSONArray array = new JSONArray();
            for (HomeCofig config:configs){

                array.add(JSONObject.toJSON(config));
            }
            object.put("data",array);
        }
        return object;
    }
    @GetMapping("/homeupdateab")
    public JSONObject updateContent(String homeCofig){
        JSONObject object = new JSONObject();
        return object;
    }
    @RequestMapping("/homeupdatea")
    @ResponseBody
    public JSONObject updateContent(@RequestBody HomeCofig cofig){
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
    @RequestMapping("/homeupdate")
    @ResponseBody
    public JSONObject updateContent(JSONObject homeCofig){
        JSONObject object = new JSONObject();
        HomeCofig config = homeConfigService.findById(homeCofig.getString("id"));
//        if (config !=  null){
//            if (!StringTool.isEmpty(imageUrl)) {
//                config.setImageurl(imageUrl);
//            }
//            if (!StringTool.isEmpty(url)) {
//                config.setUrl(url);
//            }
//            if (!StringTool.isEmpty(title)) {
//                config.setTitle(title);
//            }
//            config.setExtra(extra);
//            homeConfigService.update(config);
//            object.put("status","success");
//        }
//        else{
//            object.put("status","no find");
//        }

        return object;
    }
}
