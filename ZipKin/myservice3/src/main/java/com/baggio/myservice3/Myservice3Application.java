package com.baggio.myservice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Myservice3Application {

    public static void main(String[] args) {
        SpringApplication.run(Myservice3Application.class, args);
    }

}
