package com.positive.countrylibrary.service.impl;

import com.positive.countrylibrary.bean.HomeCofig;
import com.positive.countrylibrary.repository.HomeConfigRepository;
import com.positive.countrylibrary.repository.UserRepository;
import com.positive.countrylibrary.service.HomeConfigService;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.service.impl
 * @filename HomeConfigServiceImpl
 * @data 2023/3/4
 * @description TODO
 */
@Service
public class HomeConfigServiceImpl implements HomeConfigService {
    @Resource(name = "homeConfigRepository")//名称通过name属性指定，如果没有写name就用字段名查找
//    @Autowired(required = false)//默认按照类型装配，如果允许为空，可以设置required=false
    private HomeConfigRepository homeConfigRepository;
    @Override
    public List<HomeCofig> findAll() {
        return homeConfigRepository.findAll();
    }

    @Override
    public void update(HomeCofig cofig) {
        homeConfigRepository.save(cofig);
    }

    @Override
    public HomeCofig findById(String id) {
        return homeConfigRepository.findById(id).get();
    }

}
