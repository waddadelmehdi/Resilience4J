package ma.wem.serviceb;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceBController {
    @Autowired
    @LoadBalanced  // Enables client-side load balancing
    private RestTemplate restTemplate;

    @GetMapping("/serviceB")  // Maps HTTP GET requests to this method
    @CircuitBreaker  // Enables the Circuit Breaker pattern for fault tolerance
    public String serviceB() {
        // Calls Service A and returns its response
        String response = restTemplate.getForObject("http://service-a/serviceA", String.class);
        return "Service B calls " + response;  // Response from Service B
    }
}
