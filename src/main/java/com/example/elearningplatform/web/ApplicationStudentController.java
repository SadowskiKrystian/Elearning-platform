package com.example.elearningplatform.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpSession;

public class ApplicationStudentController {
    @GetMapping({"/student/index"})
    public String getLoggedIndex(Model model, HttpSession session, HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = request.getAuthType();
        model.addAttribute("user", auth);
        model.addAttribute("enum", role);
        return "index";
    }

}
