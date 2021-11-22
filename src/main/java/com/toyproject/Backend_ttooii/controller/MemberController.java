package com.toyproject.Backend_ttooii.controller;

import com.toyproject.Backend_ttooii.dto.MemberDto;
import com.toyproject.Backend_ttooii.service.MemberService;
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
    private MemberService userService;

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
        userService.createUser(memberDto);

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

    /*
    @GetMapping("/user/wishlist")
    public String wishList(Principal principal,
                           Model model){
        if(principal != null) {
            Member member = userService.findByUserId(principal.getName());
            List<Wish> wishList = wishService.findMyWishList(account.getId());
            List<Product> products = new ArrayList<>();
            for(Wish w : wishList){
                products.add(productService.findByIdProduct(w.getProduct().getId()));
            }
            model.addAttribute("products",products);
        }
        return "users/wishlist";
    }

    @GetMapping(value="/user/myorders")
    public String myOrders(Principal principal,
                           Model model){
        if(principal == null){
            model.addAttribute("message","회원만 접근하실수 있습니다");
        }

        List<Order> orders = orderService.findMyOrderList(principal.getName());
        model.addAttribute("orders",orders);
        System.out.println(principal.getName());
        return "users/myorders";
    }
     */
}
