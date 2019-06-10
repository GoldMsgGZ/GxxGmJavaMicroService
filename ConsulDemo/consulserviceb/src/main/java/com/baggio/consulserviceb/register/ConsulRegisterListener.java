package com.baggio.consulserviceb.register;

import com.orbitz.consul.Consul;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class ConsulRegisterListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Consul consul = contextRefreshedEvent.getApplicationContext().getBean(Consul.class);
        ConsulProperties consulProperties = contextRefreshedEvent.getApplicationContext().getBean(ConsulProperties.class);

        try {
            int servicePort = consulProperties.getServicePort();
            URL healthUrl = URI.create(consulProperties.getHealthUrl()).toURL();
            int healthInterval = consulProperties.getHealthInterval();
            String serviceName = consulProperties.getServiceName();
            String serviceTag = consulProperties.getServiceTag();

            consul.agentClient().register(servicePort, healthUrl, healthInterval, serviceName, serviceName, serviceTag);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
