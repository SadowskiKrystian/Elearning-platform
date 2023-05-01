package com.example.elearningplatform.web;

import com.example.elearningplatform.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    private final NewsService newsService;

    public ApplicationController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping({"/", "", "/index"})
    public String getIndex(){
        return "index";
    }
    @GetMapping({"/news"})
    public String getNews(){
        return "news";
    }

    @GetMapping({"/login"})
    public String getLogin(){

        return "login";
    }

}
