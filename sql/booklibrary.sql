DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (`user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                            `username` varchar(255) DEFAULT NULL COMMENT '用户名',
                            `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
                            `password` varchar(255) DEFAULT NULL COMMENT '密码',
                            `enabled` bigint(20) DEFAULT NULL COMMENT '状态：1启用、0禁用',

                            PRIMARY KEY (`user_id`) USING BTREE,

                            UNIQUE KEY `username` (`username`) USING BTREE,
                            UNIQUE KEY `uniq_username` (`username`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ( 2, 'admin', '管理员', '18888888888', 1);
COMMIT;
DROP TABLE IF EXISTS `home_config`;
CREATE TABLE `home_config` (`id` varchar(255) NOT NULL  COMMENT 'ID',
                         `imageurl` varchar(255) DEFAULT NULL COMMENT '图片地址',
                         `url` varchar(255) DEFAULT NULL COMMENT '路由地址',
                         `title` varchar(255) DEFAULT NULL COMMENT '标题',
                         `extra` varchar(255) DEFAULT NULL COMMENT '拓展字段'




) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='图片配置';
INSERT INTO `home_config` VALUES ( '1', 'xxx', '路由地址', '标题', '拓展字段');
