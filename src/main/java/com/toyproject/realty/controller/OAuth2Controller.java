package com.toyproject.realty.controller;


import com.toyproject.realty.dto.MemberDto;
import com.toyproject.realty.dto.SocialMemberDto;
import com.toyproject.realty.service.OAuth2SignupService;
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
public class OAuth2Controller {
    @Autowired
    private OAuth2SignupService oAuth2SignupService;

    @GetMapping({"", "/"})
    public String getAuthorizationMessage() {
        return "home";
    }


    @GetMapping("/login")
    public String login(Authentication authentication) {
        UserDetails userDetails=(UserDetails) authentication.getPrincipal();
        System.out.println("dddd");
        System.out.println(userDetails.getUsername());
        return "login";
    }


    @GetMapping("/loginSuccess")
    public String loginSuccess(Authentication authentication) {
        boolean exist=oAuth2SignupService.findDB(authentication);
        System.out.println(exist);
        String page="redirect:/mainPage";

        if(exist==false){page= "redirect:/socialSignup";}
        return page;
    }

    @GetMapping("/mainPage")
    public String maingPage(){
        return "/mainPage";
    }

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
        oAuth2SignupService.socialJoinUser(memberDto,authentication);
        return "redirect:/mainPage";
    }

    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "loginFailure";
    }
}
