package com.baggio.controller;

import com.baggio.model.UserDomain;
import com.baggio.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api("用户相关接口")
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @ApiOperation("添加用户")
//    @ApiImplicitParams({
//
//    })
    @ResponseBody
    @PostMapping("/add")
    public int addUser(UserDomain user) {
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        return userService.findAllUser(pageNum, pageSize);
    }
}
