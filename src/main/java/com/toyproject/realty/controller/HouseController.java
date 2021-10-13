package com.toyproject.realty.controller;

import com.toyproject.realty.dto.HouseDto;
import com.toyproject.realty.service.HouseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HouseController {

    private HouseService houseService;

    /* 게시글 목록 */
    @GetMapping("/house/list")
    public String list(Model model) {
        List<HouseDto> houseList = houseService.getHouseList();

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
