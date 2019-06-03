package com.baggio.firstboot.controller;

import com.baggio.firstboot.model.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api("user相关api")
/**
 * @RestController
 * 此注解是一个复合注解，包含的比较重要的注解是：
 * - @Controller
 * - @ResponseBody
 * 指定controller返回的对象自动化转换为json格式并返回（基本类型及其包装类、Spring除外）
 */
@RestController
//@RequestMapping("/firstboot")
@RequestMapping("/user")
public class FirstBootController {

//    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
//    public String sayHello() {
//        return "hello, this is my first boot program !!!";
//    }

    @ApiOperation("根据ID获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query",
                    name = "id",
                    dataType = "int",
                    required = true,
                    value = "用户的id",
                    defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public User getUserInfo(@RequestParam("id") int id) {
        if (id == 1) {
            return new User(1, "用户1", "123456");
        }

        return new User(2, "用户2", "111111");
    }
}
