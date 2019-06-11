package com.baggio.consulservicea.discover;

import com.orbitz.consul.Consul;
import com.orbitz.consul.model.health.ServiceHealth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServerDiscovery {
    @Autowired
    private Consul consul;

    public List<Server> getServerList(String serviceName) {
        List<Server> upServerList = new ArrayList<>();
        List<ServiceHealth> avaliableServers = consul.healthClient().getHealthyServiceInstances(serviceName).getResponse();

        avaliableServers.forEach(x->upServerList.add(new Server(x.getNode().getAddress(), x.getService().getPort())));
        return upServerList;
    }
}
