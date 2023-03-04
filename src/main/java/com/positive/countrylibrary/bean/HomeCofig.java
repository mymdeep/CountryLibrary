package com.positive.countrylibrary.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.bean
 * @filename HomeCofig
 * @data 2023/3/4
 * @description TODO
 */
@Setter
@Getter
@Entity
@Table(name = "home_config")
public class HomeCofig {
    @Id
    private String id;
    private String imageurl;
    private String url;
    private String title;
    private String extra;
}
