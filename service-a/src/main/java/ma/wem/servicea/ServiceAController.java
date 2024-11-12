package ma.wem.servicea;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAController {
    @GetMapping("/serviceA")
    public String serviceA() {
        return "Hello from Service A";
    }
}
