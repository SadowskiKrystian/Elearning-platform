package com.example.elearningplatform.repository;

import com.example.elearningplatform.dto.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    @Override
    List<News> findAll();
}
