package com.baggio.register;

import com.orbitz.consul.Consul;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class ConsulRegisterListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Consul consul = event.getApplicationContext().getBean(Consul.class);
        ConsulProperties consulProperties = event.getApplicationContext().getBean(ConsulProperties.class);

        int port = consulProperties.getServicePort();
        int interval = consulProperties.getHealthInterval();
        String serviceName = consulProperties.getServiceName();
        String serviceTag = consulProperties.getServiceTag();
        String healthUrl = consulProperties.getHealthUrl();
        try {
            consul.agentClient().register(
                    port,
                    new URI(healthUrl).toURL(),
                    interval,
                    serviceName,
                    serviceName,
                    serviceTag);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
