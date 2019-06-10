package com.baggio.consulserviceb.register;

import com.orbitz.consul.Consul;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsulConfig {
    @Bean
    public Consul consul() {
        return Consul.newClient();
    }
}
