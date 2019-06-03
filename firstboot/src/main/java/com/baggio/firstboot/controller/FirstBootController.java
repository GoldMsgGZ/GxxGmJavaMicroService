package com.baggio.firstboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController
 * 此注解是一个复合注解，包含的比较重要的注解是：
 * - @Controller
 * - @ResponseBody
 * 指定controller返回的对象自动化转换为json格式并返回（基本类型及其包装类、Spring除外）
 */
@RestController
@RequestMapping("/firstboot")
public class FirstBootController {

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello() {
        return "hello, this is my first boot program !!!";
    }
}
