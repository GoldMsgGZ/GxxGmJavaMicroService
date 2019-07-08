package com.baggio.dubboclient.controller;

import com.baggio.dubboclient.service.ComputeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("测试接口")
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    ComputeService computeService;

    @ApiOperation("测试加法")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return computeService.add(1, 2);
    }
}
