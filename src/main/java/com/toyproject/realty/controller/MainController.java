package com.toyproject.realty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class MainController {

    // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "/index";
    }
}
