package com.baggio.consulservicea;

import com.baggio.consulservicea.register.ConsulRegisterListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ConsulserviceaApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConsulserviceaApplication.class);
        app.addListeners(new ConsulRegisterListener());
        app.run(args);
//        SpringApplication.run(ConsulserviceaApplication.class, args);
    }

}
