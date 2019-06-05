package com.baggio.dbandcache.dao;

import com.baggio.dbandcache.mapper.UserMapper;
import com.baggio.dbandcache.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;  // IDEA报了一个错，可能不用管，先跑再说

    public User selectByPrimaryKey(long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
