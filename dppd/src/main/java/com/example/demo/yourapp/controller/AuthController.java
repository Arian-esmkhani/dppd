package com.example.demo.yourapp.controller;

import org.springframework.stereotype.Controller;
import com.example.demo.yourapp.model.User;
import com.example.demo.yourapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.yourapp.dto.LoginRequest;

@Controller
public class HelloController {

    @GetMapping("/")
    public String homePage() {

        return "index";
    }
}

@Controller
public class SignupController {

    @GetMapping("/signup")
    public String signPage() {

        return "sign";
    }
}

@Controller
public class LoginController {

    @GetMapping("/login")
    public String logPage() {

        return "loggin";
    }
}

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ثبت نام کاربر جدید
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        if (userService.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body("نام کاربری قبلاً استفاده شده است!");
        }
        if (userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("ایمیل قبلاً استفاده شده است!");
        }

        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    // ورود کاربر
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            User authenticatedUser = userService.authenticate(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
            );
            return ResponseEntity.ok("ورود موفق! خوش آمدید " + authenticatedUser.getUsername());
        } catch (Exception e) {
            return ResponseEntity.status(401).body("نام کاربری یا رمز عبور نادرست!");
        }
    }
}
