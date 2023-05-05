package com.example.elearningplatform.web;

import com.example.elearningplatform.auth.UserRole;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.elearningplatform.dto.Login;

import jakarta.servlet.http.HttpSession;

@Controller
public class ApplicationAdminController {
    @GetMapping({"/logging"})
    public String getLoggedIndex(Model model, HttpSession session){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("users", auth.getPrincipal());
        if(auth != null){
            for (GrantedAuthority a : auth.getAuthorities()) {
                if (a.getAuthority().equals(UserRole.ADMIN.getCodeWithRole())){
                return "/admin/index";
            }
            if (a.getAuthority().equals(UserRole.QUEST.getCodeWithRole())){
                return "student-index";
            }
            }
        }
        return "login";
    }
    @GetMapping({"/admin/api/index"})
    public String getAdminIndex(){
        return "/admin/index";
    }



}
