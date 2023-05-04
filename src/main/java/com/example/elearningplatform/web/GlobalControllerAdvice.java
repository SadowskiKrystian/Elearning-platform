package com.example.elearningplatform.web;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("links")
    public List<Map<String, String>> addLinksToModel() {
        return Arrays.asList(
            Map.of("name", "Home", "href", "/"),
            Map.of("name", "News", "href", "/news"),
            Map.of("name", "Login", "href", "/login"),
            Map.of("name", "Register", "href", "/register")
        );
    }

}