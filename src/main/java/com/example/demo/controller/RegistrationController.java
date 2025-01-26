//package com.example.demo.controller;
//
//import com.example.demo.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller
//public class RegistrationController {
//    private final UserService userService;
//
//    public RegistrationController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/register")
//    public String showRegistrationForm() {
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String registerUser(@RequestParam String username,
//                               @RequestParam String password,
//                               RedirectAttributes redirectAttributes) {
//        boolean isRegistered = userService.registerUser(username, password);
//
//        if (!isRegistered) {
//            redirectAttributes.addFlashAttribute("error", "Username already exists!");
//            return "redirect:/register";
//        }
//
//        redirectAttributes.addFlashAttribute("success", "Registration successful! Please log in.");
//        return "redirect:/login";
//    }
//}
