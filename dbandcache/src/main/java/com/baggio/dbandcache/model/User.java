package com.baggio.dbandcache.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 这里原先是MyBatisGenerator生成的文件，同时还生成了对应的Get和Set方法
 * 这里使用lombok注解，可以隐藏掉Get和Set方法，使代码更简洁
 */
@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String phone;

}