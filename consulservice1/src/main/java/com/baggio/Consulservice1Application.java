package com.baggio;

import com.baggio.register.ConsulRegisterListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Consulservice1Application {

    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(Consulservice1Application.class);
        sa.addListeners(new ConsulRegisterListener());
        sa.run(args);
//        SpringApplication.run(Consulservice1Application.class, args);
    }

}
