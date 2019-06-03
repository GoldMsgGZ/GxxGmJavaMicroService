package com.baggio.firstboot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@ApiModel("用户模型")
@AllArgsConstructor
/**
 * @Getter
 * Lombok的一个注解，用来为POJO类生成getter方法
 */
@Getter
public class User {
    @ApiModelProperty("用户ID")
    private int id;
    @ApiModelProperty("用户姓名")
    private String name;
    @ApiModelProperty("用户密码")
    private String password;
}
