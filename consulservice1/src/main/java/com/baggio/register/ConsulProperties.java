package com.baggio.register;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ConsulProperties {
    @Value("${service.name}")
    private String serviceName;
    @Value("${service.port:8090}")
    private int servicePort;
    @Value("${service.tag:dev}")
    private String serviceTag;
    @Value("${health.url}")
    private String healthUrl;
    @Value("${health.interval:10}")
    private int healthInterval;
}
