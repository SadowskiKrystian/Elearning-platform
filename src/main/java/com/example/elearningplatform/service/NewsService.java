package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.News;
import com.example.elearningplatform.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> findAll(){
        return newsRepository.findAll();
    }
}
