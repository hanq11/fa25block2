package com.example.sd20204sof3062.buoi1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class TestAuthorizeController {
    @GetMapping("/user") // User vao
    public String userController() {
        return "Hello User";
    }

    @GetMapping("/admin") // Admin vao
    public String adminController() {
        return "Hello Admin";
    }

    @GetMapping("/dashboard") // Ca user, admin deu vao duoc
    public String dashboardController() {
        return "Hello Dashboard";
    }

    @GetMapping("/public") // Khong can login cung vao duoc
    public String publicController() {
        return "Hello Public";
    }
}
