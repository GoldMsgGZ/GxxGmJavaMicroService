package com.baggio.dao;

import com.baggio.model.UserDomain;

import java.util.List;

public interface UserDao {
    int insert(UserDomain record);
    List<UserDomain> selectUsers();
}
