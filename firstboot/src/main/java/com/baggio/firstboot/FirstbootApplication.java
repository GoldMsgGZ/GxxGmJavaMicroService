package com.baggio.firstboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @SpringBootApplication
 * 这是一个复合注解，包含了以下几个重要的注解：
 * - @SpringBootConfiguration:此注解也是一个复合注解，其中最主要的注解是@Configuration:指明该类由Spring容器管理。
 * - @EnableAutoConfiguration:此注解用于启动服务的自动配置功能。
 * - @ComponentScan:此注解用于扫描类，其作用类似于Spring中的<context:component-scan></context:component-scan>标签
 */
@SpringBootApplication

/**
 * @EnableSwagger2
 * 这个注解用于启动Swagger2
 */
@EnableSwagger2
public class FirstbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstbootApplication.class, args);
    }

}
