package com.toyproject.realty.controller;
import static com.toyproject.realty.entity.ProviderType.*;
import static com.toyproject.realty.entity.RoleType.*;
import com.toyproject.realty.dto.MemberDto;
import com.toyproject.realty.service.MemberService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
@Controller
@AllArgsConstructor
@Api(tags = {"회원가입 로그인 API"})
public class MemberController {
    private MemberService memberService;

    @ApiOperation(value = "회원가입")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "아이디", required = true),
            @ApiImplicitParam(name = "password", value = "비밀번호", required = true),
            @ApiImplicitParam(name = "name", value = "닉네임", required = true),
            @ApiImplicitParam(name = "email", value = "이메일", required = true),
            @ApiImplicitParam(name = "phone", value = "휴대폰번호", required = true),
            @ApiImplicitParam(name = "address", value = "주소", required = true)})
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
        System.out.println(memberService.checkUserIdDuplicate(memberDto.getUserId()));
        memberService.joinUser(memberDto);
        return "redirect:/";
    }
    @ApiOperation(value = "회원가입시 이메일 중복 확인/uri에 email값 넘겨줘야 됩니다/중복 시 true 반환")
    @GetMapping("/user/signup/checkEmail/{email}")
    public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String email){
        return ResponseEntity.ok(memberService.checkEmailDuplicate(email));
    }

    @ApiOperation(value = "회원가입시 아이디 중복 확인/uri에 userId값 넘겨줘야 됩니다/중복 시 true 반환")
    @GetMapping("/user/signup/checkUserId/{userId}")
    public ResponseEntity<Boolean> checkUserIdDuplicate(@PathVariable String userId){
        return ResponseEntity.ok(memberService.checkUserIdDuplicate(userId));
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