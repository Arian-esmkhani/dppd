package dppd.source.backend.demo.demo.src.main.java.com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

//@RestController
//public class HelloController {
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "Hello, World!";
//    }
//}

@Controller
public class FrontendController {
    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }
}