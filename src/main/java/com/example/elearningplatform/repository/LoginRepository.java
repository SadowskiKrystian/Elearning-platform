package com.example.elearningplatform.repository;

import com.example.elearningplatform.dto.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    @Override
    <S extends Login> S save(S entity);
}
