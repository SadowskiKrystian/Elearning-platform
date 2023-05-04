package com.example.elearningplatform.endpoint;

import com.example.elearningplatform.api.LoginGetRequest;
import com.example.elearningplatform.api.NewsGetListResponse;
import com.example.elearningplatform.api.NewsGetResponse;
import com.example.elearningplatform.auth.UserRole;
import com.example.elearningplatform.dto.Login;
import com.example.elearningplatform.dto.News;
import com.example.elearningplatform.dto.Profile;
import com.example.elearningplatform.service.LoginService;
import com.example.elearningplatform.service.NewsService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ElearningPlatformEndPoint {
    private NewsService newsService;
    private LoginService loginService;

    public ElearningPlatformEndPoint(NewsService newsService, LoginService loginService) {
        this.newsService = newsService;
        this.loginService = loginService;
    }

    @GetMapping("/get-news")
    public NewsGetListResponse getNews() {
        List<News> newses = newsService.findAll();
        return new NewsGetListResponse(newsesToResponse(newses));
    }
    @PostMapping("/quest/add-user")
    public void addUser(@RequestBody LoginGetRequest loginGetRequest){
        loginService.create(new Login(loginGetRequest.getEmail(), loginGetRequest.getPassword(), new Profile(loginGetRequest.getFirstName(), loginGetRequest.getSurname(), loginGetRequest.getCity(), loginGetRequest.getPhoneNumber()), UserRole.QUEST.getCodeWithRole()));
    }

    private List<NewsGetResponse> newsesToResponse(List<News> newses) {
        List<NewsGetResponse> list = new ArrayList<>();
        for (News news : newses) {
            list.add(new NewsGetResponse(news));
        }
        return list;

    }

}
