package com.example.elearningplatform.web;

import com.example.elearningplatform.auth.UserRole;
import com.example.elearningplatform.dto.Login;
import com.example.elearningplatform.exceptions.WrongLogin;
import com.example.elearningplatform.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ApplicationController {
    private final LoginService loginService;

    public ApplicationController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping({"/", "", "/index"})
    public String getIndex(Model model, HttpSession session, HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = request.getAuthType();
        model.addAttribute("user", auth);
        model.addAttribute("enum", role);
        return "index";
    }  

    @GetMapping({"/layout/layout"})
    public String getLayout(Model model, HttpSession session, HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = request.getAuthType();
        model.addAttribute("user", auth);
        model.addAttribute("enum", role);
        return "layout/layout";
    }

    @GetMapping({"/news"})
    public String getNews(Model model, HttpSession session, HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = request.getAuthType();
        model.addAttribute("user", auth);
        model.addAttribute("enum", role);
        return "news";
    }

    @GetMapping({"/login"})
    public String getLogin(Model model, HttpSession session, HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = request.getAuthType();
        model.addAttribute("user", auth);
        model.addAttribute("enum", role);
        return "login";
    }
    @GetMapping({"/register"})
    public String getRegister(Model model, HttpSession session, HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = request.getAuthType();
        model.addAttribute("user", auth);
        model.addAttribute("enum", role);
        return "register";
    }


}
