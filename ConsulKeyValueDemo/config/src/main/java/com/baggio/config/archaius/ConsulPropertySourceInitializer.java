package com.baggio.config.archaius;

import com.baggio.config.common.ServiceContants;
import com.netflix.config.*;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ConsulPropertySourceInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.setProperty("archaius.fixedDelayPollingScheduler.delayMills", "10000");

        String keyName = "service/" + ServiceContants.serviceName + "/" + ServiceContants.serviceTag;
        PolledConfigurationSource configurationSource = new ConsulConfigurationSource(keyName);
        AbstractPollingScheduler scheduler = new FixedDelayPollingScheduler();
        DynamicConfiguration configuration = new DynamicConfiguration(configurationSource, scheduler);
        ConfigurationManager.install(configuration);
    }
}
