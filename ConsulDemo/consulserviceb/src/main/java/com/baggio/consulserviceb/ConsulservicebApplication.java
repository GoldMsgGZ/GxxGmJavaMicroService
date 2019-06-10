package com.baggio.consulserviceb;

import com.baggio.consulserviceb.register.ConsulRegisterListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ConsulservicebApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConsulservicebApplication.class);
        app.addListeners(new ConsulRegisterListener());
        app.run(args);
//        SpringApplication.run(ConsulservicebApplication.class, args);
    }

}
