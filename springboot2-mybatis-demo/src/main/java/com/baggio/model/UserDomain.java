package com.baggio.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDomain {
    private Integer userId;
    private String userName;
    private String password;
    private String phone;
}
