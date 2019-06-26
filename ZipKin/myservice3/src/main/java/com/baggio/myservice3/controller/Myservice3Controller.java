package com.baggio.myservice3.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("myservice3相关API")
@RestController
@RequestMapping("/myservice3/zipkin")
public class Myservice3Controller {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        try {
            return "myservice3-response";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
