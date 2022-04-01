package com.toyproject.Backend_ttooii.controller;

import com.toyproject.Backend_ttooii.dto.MemberDto;
import com.toyproject.Backend_ttooii.service.MemberService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
@Api(tags = {"회원가입 로그인 API"})
public class MemberController {
    private MemberService userService;

    @GetMapping("/user/signup")
    public String createdUserForm(Model model){
        model.addAttribute("userForm",new MemberDto());
        return "/signup";
    }

    @ApiOperation(value = "회원가입")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "아이디", required = true),
            @ApiImplicitParam(name = "password", value = "비밀번호", required = true),
            @ApiImplicitParam(name = "name", value = "닉네임", required = true),
            @ApiImplicitParam(name = "email", value = "이메일", required = true),
            @ApiImplicitParam(name = "phone", value = "휴대폰번호", required = true)})

    @RequestMapping(value = "/user/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createUser(@RequestBody @Valid MemberDto memberDto, BindingResult result){
        if(result.hasErrors()){
            return "/signup";
        }
        userService.createUser(memberDto);

        return "redirect:/";
    }

    @ApiOperation(value = "로그인 페이지")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "아이디", required = true),
            @ApiImplicitParam(name = "password", value = "비밀번호", required = true)})
    @GetMapping("/user/login")
    public String dispLogin() {
        return "/login";
    }


    @ApiOperation(value = "로그인결과 페이지")
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "redirect:/";
    }


    @ApiOperation(value = "로그아웃 결과 페이지")
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/logout";
    }


    @ApiOperation(value = "접근 거부 페이지")
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }
}
