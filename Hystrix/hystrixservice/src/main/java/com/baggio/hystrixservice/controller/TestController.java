package com.baggio.hystrixservice.controller;

import com.alibaba.fastjson.JSON;
import com.baggio.hystrixservice.config.HystrixUtil;
import com.baggio.hystrixservice.model.User;
import com.ning.http.client.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Api("服务容错相关API")
@RestController
@RequestMapping("/hystrix")
public class TestController {
    @Autowired
    private HystrixUtil hystrixUtil;

    @ApiOperation("根据用户名获取用户信息")
    @RequestMapping(value = "/getUserByName", method = RequestMethod.GET)
    public User getUserByName(@RequestParam("username") String username) {
        User user = null;

        String url = "http://localhost:8080/myserviceD/getUser?username=" + username;
        Response response = hystrixUtil.execute("myserviceD", "getUser", url);
        if (response != null) {
            try {
                user = JSON.parseObject(response.getResponseBody(), User.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return user;
    }
}
