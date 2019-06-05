package com.baggio.dbandcache.service;

import com.baggio.dbandcache.dao.UserDao;
import com.baggio.dbandcache.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 注入UserDao，调用selectByPrimaryKey方法
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUser(long id) {
        return userDao.selectByPrimaryKey(id);
    }
}
