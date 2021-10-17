package com.toyproject.realty.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class MainController {

    // 메인 페이지
    @ApiOperation(value = "메인페이지")
    @GetMapping("/")
    public String index() {
        return "/index";
    }
}