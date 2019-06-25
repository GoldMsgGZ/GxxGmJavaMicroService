package com.baggio.rpcserver.controller;

import com.baggio.rpcserver.model.User;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Api("用户相关API")
@RestController
@RequestMapping("/User")
public class UserController {
    //@ApiOperation("根据用户名获取用户信息")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
//    public User getUser(@RequestParam("username") String username) {
    public User getUser(@RequestParam("username") String username) {
        User user = null;
        if (username.equals("小娜")) {
            user = new User(username, 18);
        } else {
            user = new User("小刚", 20);
        }

        return user;
    }
}
