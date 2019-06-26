package com.baggio.myservice4.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("myservice4相关API")
@RestController
@RequestMapping("/myservice4/zipkin")
public class Myservice4Controller {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        try {
            return "myservice4-response";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
