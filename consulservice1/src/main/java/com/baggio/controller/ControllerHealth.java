package com.baggio.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("健康检查接口")
@RestController
@RequestMapping("/health")
public class ControllerHealth {
    @ApiOperation("健康检查")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "UP";
    }
}
