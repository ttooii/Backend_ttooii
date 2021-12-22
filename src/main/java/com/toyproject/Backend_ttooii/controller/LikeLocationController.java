package com.toyproject.Backend_ttooii.controller;


import com.toyproject.Backend_ttooii.dto.LikeLocationDto;
import com.toyproject.Backend_ttooii.service.LikeLocationService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class LikeLocationController {

    @Autowired
    LikeLocationService likeLocationService;

    // 지역 즐겨찾기
    @ApiOperation(value = "지역 즐겨찾기 생성")
    @ApiImplicitParam(name = "likeLocationDto", value = "지역 즐겨찾기")
    @GetMapping("/likeLocation/like/{district}")
    public String saveLikeLocaiton(LikeLocationDto likeLocationDto) {

        likeLocationService.saveLikeLocation(likeLocationDto);

        return "/saveLikeLocation";
    }

    @ApiOperation(value="지역 즐겨찾기 가져오기")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "district", value = "지역"),
            @ApiImplicitParam(name = "userId", value = "유저 정보")})
    @PostMapping(value = "/likeLocation/{userId}", produces = "application/json; charset=utf8")
    public String likeLocation(@PathVariable("userId") String userId, Model model) {

        List<LikeLocationDto> likeLocationDto = likeLocationService.getLikeLocList(userId);
        model.addAttribute("likeLocationDto", likeLocationDto);

        return "/getLikeLocation";
    }
}
