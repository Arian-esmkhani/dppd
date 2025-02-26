package dppd.source.backend.demo.demo.src.main.java.com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @GetMapping("/hello")
    public String seyHello() {
        return "Hello, World!";
    }
}
