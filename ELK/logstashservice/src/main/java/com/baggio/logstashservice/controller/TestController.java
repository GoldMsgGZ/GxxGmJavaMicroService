package com.baggio.logstashservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("logstash相关API")
@RestController
@RequestMapping("/logstash")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @ApiOperation("测试logstash")
    @RequestMapping(value = "/test/{username}", method = RequestMethod.GET)
    public int getUserAge(@PathVariable("username") String username) {
        int age = 0;

        LOGGER.info("start: getUserAge, username:'{}'", username);

        if (username.equals("小红")) {
            age = 18;
            LOGGER.debug("end: getUserAge, username:'{}', age:'{}'", username, age);
        } else {
            age = 20;
            LOGGER.error("end: getUserAge, username:'{}', age:'{}'", username, age);
        }

        return age;
    }
}
