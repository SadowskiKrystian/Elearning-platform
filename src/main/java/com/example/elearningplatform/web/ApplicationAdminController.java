package com.example.elearningplatform.web;

import com.example.elearningplatform.auth.UserRole;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
@Controller
public class ApplicationAdminController {

    @GetMapping({"/admin/api/users"})
    public String getAdminUser(){
        return "/admin/admin-user";
    }

    @GetMapping({"/admin/api/news"})
    public String getAdminNews(){
        return "/admin/admin-news";
    }

    @GetMapping({"/admin/api/notification"})
    public String getAdminNotification(){
        return "/admin/admin-notification";
    }


}
