package com.ecommerce.discoveryservice;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HealthController {
  
    @GetMapping("/health")
    public String health() {
        return "discoveryservice service is running";
    }
    
}
