package com.baggio.config.archaius;

import com.google.common.base.Optional;
import com.netflix.config.PollResult;
import com.netflix.config.PolledConfigurationSource;
import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;
import org.apache.commons.lang3.StringUtils;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConsulConfigurationSource implements PolledConfigurationSource {

    private String keyName;

    public ConsulConfigurationSource(String keyName) {
        this.keyName = keyName;
    }

    @Override
    public PollResult poll(boolean b, Object o) throws Exception {
        KeyValueClient kvClient = Consul.newClient().keyValueClient();
        Optional<String> kvOpt = kvClient.getValueAsString(keyName);
        String kvStr = StringUtils.EMPTY;
        if (kvOpt.isPresent()) {
            kvStr = kvOpt.get();
        }

        Properties props = new Properties();
        props.load(new StringReader(kvStr));

        Map<String, Object> propMap = new HashMap<>();
        for (Object key : props.keySet()) {
            propMap.put((String)key, props.get(key));
        }

        return PollResult.createFull(propMap);
    }
}
