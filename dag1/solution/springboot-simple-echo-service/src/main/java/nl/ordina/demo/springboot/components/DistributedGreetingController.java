package nl.ordina.demo.springboot.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DistributedGreetingController {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @RequestMapping("/distributed-greeting")
    public String getGreeting() {
        return restTemplate.getForObject("http://localized-greeting-service/greeting", String.class);
    }

}
