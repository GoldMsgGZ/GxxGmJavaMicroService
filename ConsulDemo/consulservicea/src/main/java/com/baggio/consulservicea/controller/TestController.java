package com.baggio.consulservicea.controller;

import com.baggio.consulservicea.discover.Server;
import com.baggio.consulservicea.discover.ServerDiscovery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("测试API")
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ServerDiscovery serverDiscovery;

    @ApiOperation("根据serviceName获取服务列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "serviceName", dataType = "string", required = true, value = "服务名称")
    })
    @RequestMapping(value = "/getServiceList", method = RequestMethod.GET)
    public List<Server> getServiceList(@RequestParam("serviceName") String serviceName) {
        return serverDiscovery.getServerList(serviceName);
    }
}
