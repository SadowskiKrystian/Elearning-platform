package com.example.elearningplatform.repository;

import com.example.elearningplatform.dto.Login;
import com.example.elearningplatform.filter.LoginFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Long> {
    @Override
    <S extends Login> S save(S entity );
@Query("select l from Login as l where l.email = :loginfilter")
    public List<Login> findByEmail(@Param("loginfilter") String loginFilter);
}
