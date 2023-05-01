package com.example.elearningplatform.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationAdminController {
    @GetMapping({"/admin/index"})
    public String getLoggedIndex(){

        return "login-in";
    }
}
