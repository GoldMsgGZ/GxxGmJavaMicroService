package com.baggio.myservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Myservice2Application {

    public static void main(String[] args) {
        SpringApplication.run(Myservice2Application.class, args);
    }

}
