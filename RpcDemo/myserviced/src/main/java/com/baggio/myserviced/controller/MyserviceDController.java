package com.baggio.myserviced.controller;

import com.baggio.myserviced.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Api("myserviceD相关API")
@RestController
@RequestMapping("/myserviceD")
public class MyserviceDController {
    @ApiOperation("根据用户名获取用户信息")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(@RequestParam("username") String username) {
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        User user = null;

        if (username.equals("小娜")) {
            user = new User(username, 18);
        } else{
            user = new User("小刚", 20);
        }

        return user;
    }
}
