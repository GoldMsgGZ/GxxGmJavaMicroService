package com.baggio;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.baggio.dao")
@EnableSwagger2
public class Springboot2MybatisDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(Springboot2MybatisDemoApplication.class, args);
    }

}
