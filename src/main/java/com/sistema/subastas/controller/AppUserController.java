package com.sistema.subastas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.subastas.model.AppUser;
import com.sistema.subastas.service.AppUserService;

@Controller
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(AppUser user) {
        appUserService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @GetMapping("/profile")
    public String viewProfile(Model model) {
        // Implement logic to get the logged-in user's profile
        return "userProfile";
    }
}