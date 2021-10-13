package com.toyproject.realty.controller;

import com.toyproject.realty.dto.MemberDto;
import com.toyproject.realty.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
@Controller
@AllArgsConstructor
@Api(tags = {"회원가입 로그인 API"})
public class MemberController {
    private MemberService userService;

    @ApiOperation(value = "회원가입")
    @GetMapping("/user/signup")
    public String createUserForm(Model model){
        model.addAttribute("userForm",new MemberDto());
        return "/signup";
    }

    @PostMapping("/user/signup")
    public String createUser(@Valid MemberDto memberDto, BindingResult result){
        if(result.hasErrors()){
            return "/signup";
        }
        userService.createUser(memberDto);

        return "redirect:/";
    }

    // 로그인 페이지
    @ApiOperation(value = "로그인 페이지")
    @GetMapping("/user/login")
    public String dispLogin() {
        return "/login";
    }

    // 로그인 결과 페이지
    @ApiOperation(value = "로그인결과 페이지")
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "/loginSuccess";
    }

    // 로그아웃 결과 페이지
    @ApiOperation(value = "로그아웃 결과 페이지")
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/logout";
    }

    // 접근 거부 페이지
    @ApiOperation(value = "접근 거부 페이지")
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    // 내 정보 페이지
    @ApiOperation(value = "내 정보 페이지")
    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "/myinfo";
    }

    // 어드민 페이지
    @ApiOperation(value = "어드민 페이지")
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin";
    }
}
