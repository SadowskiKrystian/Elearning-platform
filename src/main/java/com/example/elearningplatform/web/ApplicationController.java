package com.example.elearningplatform.web;

import com.example.elearningplatform.dto.Login;
import com.example.elearningplatform.exceptions.WrongLogin;
import com.example.elearningplatform.service.LoginService;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationController {
    private final LoginService loginService;

    public ApplicationController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        try {
            Login user = loginService.validateLogin(email, password);
            if (user == null) {
                return "redirect:/login";
            }
            session.setAttribute("user", user);
            if (user.getRole().equals("ADMIN")) {
                return "redirect:/admin/index";
            } else if (user.getRole().equals("STUDENT")) {
                return "redirect:/student/index";
            } else if (user.getRole().equals("USER")){
                return "redirect:/waiting-room";
            } else {
                return "redirect:/login";
            }
        } catch (WrongLogin e) {
            return "redirect:/login";
        }
    }



    @GetMapping({"/waiting-room"})
    public String getLoggedPage(Model model, HttpSession session){
        Login user = (Login) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("email", user.getEmail());
            model.addAttribute("role", user.getRole());
            if (user.getRole() == "STUDENT") {
                return "redirect:/student/index";
            } else if (user.getRole() == "ADMIN") {
                return "redirect:/admin/index";
            } else {
                return "waiting-room";
            }
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping({"/", "", "/index"})
    public String getIndex(Model model, HttpSession session){
        Login user = (Login) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("email", user.getEmail());
            model.addAttribute("role", user.getRole());
        }
        return "index";
    }
        
    @GetMapping({"/layout/layout"})
    public String getLayout(Model model){
        return "layout/layout";
    }

    @GetMapping({"/news"})
    public String getNews(Model model, HttpSession session){
        Login user = (Login) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("email", user.getEmail());
            model.addAttribute("role", user.getRole());
        }
        return "news";
    }

    @GetMapping({"/login"})
    public String getLogin(Model model, HttpSession session){
        Login user = (Login) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("email", user.getEmail());
            model.addAttribute("role", user.getRole());
            if (user.getRole() == "STUDENT") {
                return "redirect:/student/index";
            } else if (user.getRole() == "ADMIN") {
                return "redirect:/admin/index";
            } else if (user.getRole() == "USER") {
                return "redirect:/waiting-room";
            } else {
                return "login";
            }
        }
        return "login";
    }

    @GetMapping({"/register"})
    public String getRegister(Model model, HttpSession session){
        Login user = (Login) session.getAttribute("user");
        if (user != null) {
            if (user != null) {
                model.addAttribute("email", user.getEmail());
                model.addAttribute("role", user.getRole());
                if (user.getRole() == "STUDENT") {
                    return "redirect:/student/index";
                } else if (user.getRole() == "ADMIN") {
                    return "redirect:/admin/index";
                } else if (user.getRole() == "USER") {
                    return "redirect:/waiting-room";
                } else {
                    return "register";
                }
            }
        }
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
