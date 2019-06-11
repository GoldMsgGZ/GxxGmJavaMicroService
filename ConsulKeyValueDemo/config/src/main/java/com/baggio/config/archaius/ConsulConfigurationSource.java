package com.baggio.config.archaius;

import com.netflix.config.PollResult;
import com.netflix.config.PolledConfigurationSource;
import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;

public class ConsulConfigurationSource implements PolledConfigurationSource {

    private String keyName;

    public ConsulConfigurationSource(String keyName) {
        this.keyName = keyName;
    }

    @Override
    public PollResult poll(boolean b, Object o) throws Exception {
        KeyValueClient kvClient = Consul.newClient().keyValueClient();
        return null;
    }
}
