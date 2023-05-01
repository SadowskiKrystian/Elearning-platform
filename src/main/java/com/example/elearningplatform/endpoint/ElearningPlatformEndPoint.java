package com.example.elearningplatform.endpoint;

import com.example.elearningplatform.api.NewsGetListResponse;
import com.example.elearningplatform.api.NewsGetResponse;
import com.example.elearningplatform.dto.News;
import com.example.elearningplatform.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ElearningPlatformEndPoint {
    private NewsService newsService;

    public ElearningPlatformEndPoint(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/get-news")
    public NewsGetListResponse getNews() {
        List<News> newses = newsService.findAll();
        return new NewsGetListResponse(newsesToResponse(newses));
    }

    private List<NewsGetResponse> newsesToResponse(List<News> newses) {
        List<NewsGetResponse> list = new ArrayList<>();
        for (News news : newses) {
            list.add(new NewsGetResponse(news));
        }
        return list;

    }
}
