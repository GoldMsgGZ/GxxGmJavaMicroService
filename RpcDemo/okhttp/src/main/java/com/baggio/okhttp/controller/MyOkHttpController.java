package com.baggio.okhttp.controller;

import com.baggio.okhttp.model.User;
import com.baggio.okhttp.service.MyOkHttpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("OKHttp相关API")
@RestController
@RequestMapping("/OKHttp")
public class MyOkHttpController {
    @Autowired
    private MyOkHttpService myOkHttpService;

    @ApiOperation("使用OkHttp调用其他服务")
    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public User getUserByOkHttp(@RequestParam("username") String username) {
        return myOkHttpService.getUserByOkhttp(username);
    }
}
