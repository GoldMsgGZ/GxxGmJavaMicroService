package com.baggio.config;

import com.baggio.config.archaius.ConsulPropertySourceInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.Configuration;

@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConfigApplication.class);
        app.addInitializers(new ConsulPropertySourceInitializer());
        app.run(args);
//        SpringApplication.run(ConfigApplication.class, args);
    }

}
