package com.toyproject.Backend_ttooii.controller;


import com.toyproject.Backend_ttooii.dto.SocialMemberDto;
import com.toyproject.Backend_ttooii.service.OAuth2SignupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
@Api(tags = {"네이버 카카오 로그인 API"})
public class OAuth2Controller {
    @Autowired
    private OAuth2SignupService oAuth2SignupService;

    @GetMapping({"", "/"})
    public String getAuthorizationMessage() {
        return "home";
    }

    @ApiOperation(value = "네이버카카오로그인")
    @GetMapping("/login")
    public String login(Authentication authentication) {
        UserDetails userDetails=(UserDetails) authentication.getPrincipal();
        return "login";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(Authentication authentication) {
        boolean exist=oAuth2SignupService.findDB(authentication);
        String page="redirect:/mainPage";
        System.out.println(authentication.getName());

        if(exist==false){page= "redirect:/socialSignup";}
        return page;
    }
    @ApiOperation(value = "로그인 회원가입 성공 시 돌아가는 메인페이지")
    @GetMapping("/mainPage")
    public String maingPage(){
        return "/mainPage";
    }

    @ApiOperation(value = "회원가입")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "휴대폰번호", required = true)})
    @GetMapping("/socialSignup")
    public String createUserForm(Model model){
        model.addAttribute("userForm",new SocialMemberDto());
        return "/socialSignup";
    }

    @PostMapping("/socialSignup")
    public String createUser(@Valid SocialMemberDto memberDto, BindingResult result, Authentication authentication){
        if(result.hasErrors()){
            return "/socialSignup";
        }
        System.out.println(authentication.getName());

        oAuth2SignupService.socialJoinUser(memberDto,authentication);
        return "redirect:/mainPage";
    }
    @ApiOperation(value = "로그인 실패 페이지")
    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "loginFailure";
    }
}
