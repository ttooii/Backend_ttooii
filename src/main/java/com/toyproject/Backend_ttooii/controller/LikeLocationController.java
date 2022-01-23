package com.toyproject.Backend_ttooii.controller;


import com.toyproject.Backend_ttooii.dto.LikeLocationDto;
import com.toyproject.Backend_ttooii.entity.LikeLocation;
import com.toyproject.Backend_ttooii.entity.Member;
import com.toyproject.Backend_ttooii.repository.LikeLocationRepository;
import com.toyproject.Backend_ttooii.repository.MemberRepository;
import com.toyproject.Backend_ttooii.service.LikeLocationService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class LikeLocationController {

    @Autowired
    LikeLocationService likeLocationService;

    @Autowired
    LikeLocationRepository likeLocationRepository;

    @Autowired
    MemberRepository memberRepository;
    // 지역 즐겨찾기
    @ApiOperation(value = "지역 즐겨찾기 생성")
    @ApiImplicitParam(name = "likeLocationDto", value = "지역 즐겨찾기")
    @PostMapping("/likeLocation/like")
    public LikeLocation saveLikeLocaiton(@PathVariable String userId, @PathVariable Long id, @RequestBody LikeLocation likeLocation) {

        Optional<Member> member = memberRepository.findByuserId(userId);
        likeLocation.setUserId(member.get());
        LikeLocation likeLocation1 = likeLocationRepository.findById(id).get();
        likeLocation1.setDistrict(likeLocation.getDistrict());

        return likeLocation1;
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
