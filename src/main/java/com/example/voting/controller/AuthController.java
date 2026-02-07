package com.example.voting.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/default-success")
    public String defaultSuccess(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/admin/dashboard";
        } else if (request.isUserInRole("VOTER")) {
            return "redirect:/voter/dashboard";
        }
        return "redirect:/login";
    }
}
