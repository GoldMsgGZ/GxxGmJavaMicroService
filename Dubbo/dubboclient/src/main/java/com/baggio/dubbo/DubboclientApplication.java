package com.baggio.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ImportResource({"classpath:dubbo.xml"})
public class DubboclientApplication {



    public static void main(String[] args) {
        SpringApplication.run(DubboclientApplication.class, args);
    }

}
