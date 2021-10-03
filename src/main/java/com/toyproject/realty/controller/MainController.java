package com.toyproject.realty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class MainController {

    @RestController
    public class TestController {
        @GetMapping("/home")
        public String getHome() {
            return "Hello World!";
        }
    }
}
