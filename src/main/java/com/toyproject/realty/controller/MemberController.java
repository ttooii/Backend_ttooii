package com.toyproject.realty.controller;
import static com.toyproject.realty.entity.ProviderType.*;
import static com.toyproject.realty.entity.RoleType.*;
import com.toyproject.realty.dto.MemberDto;
import com.toyproject.realty.service.MemberService;
import io.swagger.annotations.*;
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
    private MemberService memberService;

    @GetMapping("/user/signup")
    public String createUserForm(Model model){
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
    @PostMapping("/user/signup")
    public String createUser(@Valid MemberDto memberDto, BindingResult result){
        if(result.hasErrors()){
            return "/signup";
        }
        memberService.joinUser(memberDto);
        return "redirect:/";
    }

    // 로그인 페이지
    @ApiOperation(value = "로그인 페이지")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "아이디", required = true),
            @ApiImplicitParam(name = "password", value = "비밀번호", required = true)})
    @GetMapping("/user/login")
    public String dispLogin() {
        return "/login";
    }

    // 로그인 결과 페이지
    @ApiOperation(value = "로그인결과 페이지")
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "redirect:/";
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