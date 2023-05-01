package com.example.elearningplatform.repository;

import com.example.elearningplatform.dto.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Long> {
    List<Login> findAll();

    @Override
    <S extends Login> S save(S entity);
}
