package com.toyproject.realty.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.annotations.Api;


@Api(tags = {"소셜 로그인 API"})
@Controller
public class OAuth2Controller {

    @GetMapping({"", "/"})
    public String getAuthorizationMessage() {
        return "home";
    }
    @ApiOperation(value = "소셜로그인")
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @ApiParam(value = "소셜로그인성공")
    @GetMapping({"/loginSuccess", "/loginSuccess"})
    public String loginSuccess() {
        return "loginSuccess";
    }
    @ApiParam(value = "소셜로그인실패")
    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "loginFailure";
    }
}
