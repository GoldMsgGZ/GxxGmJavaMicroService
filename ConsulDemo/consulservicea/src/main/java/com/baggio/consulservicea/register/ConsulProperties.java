package com.baggio.consulservicea.register;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ConsulProperties {
    @Value("${service.name}")
    private String  serviceName;

    @Value("${server.port:8080}")
    private int     servicePort;

    @Value("${service.tag:dev}")
    private String  serviceTag;

    @Value("${health.url}")
    private String  healthUrl;

    @Value("${health.interval:10}")
    private int     healthInterval;
}
