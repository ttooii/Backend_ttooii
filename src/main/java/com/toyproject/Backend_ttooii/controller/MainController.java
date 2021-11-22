package com.toyproject.Backend_ttooii.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    // 메인 페이지
    @ApiOperation(value = "메인페이지")
    @GetMapping("/")
    public String index() {
        return "/index";
    }
}