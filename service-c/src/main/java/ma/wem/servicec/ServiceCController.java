package ma.wem.servicec;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceCController {
    @Autowired
    @LoadBalanced  // Enables client-side load balancing
    private RestTemplate restTemplate;

    @GetMapping("/serviceC")  // Maps HTTP GET requests to this method
    @CircuitBreaker  // Enables the Circuit Breaker pattern for fault tolerance
    public String serviceC() {
        // Calls Service B and returns its response
        String response = restTemplate.getForObject("http://service-b/serviceB", String.class);
        return "Service C calls " + response;  // Response from Service C
    }
}
