package nl.ordina.demo.springboot.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceDiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances2/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName2(@PathVariable String applicationName) {
        List<ServiceInstance> serviceInstances = this.discoveryClient.getInstances(applicationName);
        System.out.println(serviceInstances.get(0).getUri());
        return serviceInstances;
    }

}
