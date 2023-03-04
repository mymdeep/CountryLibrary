package com.positive.countrylibrary.bean;

import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.bean
 * @filename User
 * @data 2023/3/4
 * @description
 * 实体类
 * 每个POJO类都是一个实体Bean
 */
@Setter
@Getter
@Entity
@Table(name = "sys_user")
public class User {
    @Id
    private long user_id;
    private String username;
    private String nick_name;
    private String password;
    private long enabled;
}
