package com.example.elearningplatform.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.elearningplatform.dto.Login;

import jakarta.servlet.http.HttpSession;

@Controller
public class ApplicationAdminController {
    @GetMapping({"/admin/index"})
    public String getLoggedIndex(Model model, HttpSession session){
        Login user = (Login) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("email", user.getEmail());
            model.addAttribute("role", user.getRole());
            if (user.getRole() == "STUDENT") {
                return "redirect:/student/index";
            } else if (user.getRole() == "ADMIN") {
                return "admin/index";
            } else if (user.getRole() == "USER") {
                return "redirect:/waiting-room";
            } else {
                return "redirect:/login";
            }
        } else {
            return "redirect:/login";
        }
    }
}
