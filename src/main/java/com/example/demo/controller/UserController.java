package com.example.demo.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final InMemoryUserDetailsManager userDetailsManager;

    public UserController(PasswordEncoder passwordEncoder, InMemoryUserDetailsManager userDetailsManager) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsManager = userDetailsManager;

        userDetailsManager.createUser(
                User.withUsername("user")
                        .password(passwordEncoder.encode("password"))
                        .roles("USER")
                        .build()
        );
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        if (userDetailsManager.userExists(username)) {
            model.addAttribute("error", "User already exists");
            return "register";
        }

        userDetailsManager.createUser(
                User.withUsername(username)
                        .password(passwordEncoder.encode(password))
                        .roles("USER")
                        .build()
        );

        model.addAttribute("success", "User registered successfully");
        return "login";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}



