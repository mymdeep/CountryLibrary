package com.positive.countrylibrary.service;

import com.positive.countrylibrary.bean.HomeCofig;
import com.positive.countrylibrary.bean.User;

import java.util.List;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.service
 * @filename HomeConfigService
 * @data 2023/3/4
 * @description TODO
 */
public interface HomeConfigService {
    List<HomeCofig> findAll();
    void update(HomeCofig cofig);

    HomeCofig findById(String id);
}
