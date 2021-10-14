package com.toyproject.realty.controller;

import com.toyproject.realty.dto.HouseListDto;
import com.toyproject.realty.dto.HouseSaveDto;
import com.toyproject.realty.service.HouseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class HouseController {

    private HouseService houseService;


    @ApiOperation(value = "방 등록", notes = "성공 시 방 등록에 성공합니다.")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "title", value = "제목", required = true),
             @ApiImplicitParam(name = "content", value = "내용", required = true),
             @ApiImplicitParam(name = "transactionType", value = "거래 유형", required = true),
             @ApiImplicitParam(name = "purpose", value = "목적", required = true),
             @ApiImplicitParam(name = "marketValue", value = "가격", required = true),
             @ApiImplicitParam(name = "administrationCost", value = "관리비", required = true),
             @ApiImplicitParam(name = "landArea", value = "면", required = true),
             @ApiImplicitParam(name = "roomCount", value = "방 개수", required = true),
             @ApiImplicitParam(name = "administrationCost", value = "관리비", required = true),
             @ApiImplicitParam(name = "floor", value = "층", required = true),
             @ApiImplicitParam(name = "totalFloor", value = "전체 층", required = true),
             @ApiImplicitParam(name = "bathroomCount", value = "화장실 개수", required = true),
             @ApiImplicitParam(name = "direction", value = "방향", required = true),
             @ApiImplicitParam(name = "heatingSystem", value = "난방 시스템", required = true),
             @ApiImplicitParam(name = "confirmation", value = "확인사항", required = true)})
    @PostMapping("/house/add")
    public Long save(@Valid @RequestBody HouseSaveDto houseSaveDto) {

        return houseService.save(houseSaveDto);
    }

    @ApiOperation(value = "방 목록 조회", notes = "성공 시 방 목록 조회에 성공합니다.")
    @GetMapping("/house/list")
    public String list(Model model) {
        List<HouseListDto> houseList = houseService.getHouseList();

        model.addAttribute("houseList", houseList);
        return "houselist.html";
    }

//    @GetMapping("/house/{houseId}")
//    public String index(Long houseId, Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
//
//        model.addAttribute("view", houseService.houseUpdateHit(houseId));
//        model.addAttribute("HouseList", houseService.getHouseList(pageable));
//        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber()); // 이전 버튼
//        model.addAttribute("next", pageable.next().getPageNumber()); // 다음 버튼
//        model.addAttribute("check", houseService.getListCheck(pageable)); // 마지막 글 체크
//
//        return "index";
//    }
}
