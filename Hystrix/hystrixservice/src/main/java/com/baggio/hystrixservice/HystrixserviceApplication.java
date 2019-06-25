package com.baggio.hystrixservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HystrixserviceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HystrixserviceApplication.class);
        app.run(args);
//        SpringApplication.run(HystrixserviceApplication.class, args);
    }

}
