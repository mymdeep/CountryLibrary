package com.positive.countrylibrary.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.positive.countrylibrary.bean.HomeCofig;
import com.positive.countrylibrary.service.HomeConfigService;
import com.positive.countrylibrary.service.UserService;
import com.positive.countrylibrary.util.StringTool;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/homeupdate")
    public JSONObject updateContent(String id,String imageUrl,String url,String title,String extra){
        JSONObject object = new JSONObject();
        HomeCofig config = homeConfigService.findById(id);
        if (config !=  null){
            if (!StringTool.isEmpty(imageUrl)) {
                config.setImageurl(imageUrl);
            }
            if (!StringTool.isEmpty(url)) {
                config.setUrl(url);
            }
            if (!StringTool.isEmpty(title)) {
                config.setTitle(title);
            }
            config.setExtra(extra);
            homeConfigService.update(config);
            object.put("status","success");
        }
        else{
            object.put("status","no find");
        }

        return object;
    }
}
