package com.toyproject.realty.controller;

import com.toyproject.realty.dto.HouseListDto;
import com.toyproject.realty.dto.HouseSaveDto;
import com.toyproject.realty.dto.MemberDto;
import com.toyproject.realty.service.HouseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class HouseController {

    private HouseService houseService;


    @GetMapping("/house/add")
    public String createHouseForm(Model model){
        model.addAttribute("houseForm",new HouseSaveDto());
        return "/houseAdd";
    }

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
    public String createHouse(@Valid HouseSaveDto houseSaveDto, BindingResult result) {
        if(result.hasErrors()){
            return "/houseAdd";
        }

        houseService.save(houseSaveDto);
        return "redirect:/";
    }

    @ApiOperation(value = "방 목록 조회", notes = "성공 시 방 목록 조회에 성공합니다.")
    @GetMapping("/house/list")
    public String list(Model model) {
        List<HouseListDto> houseList = houseService.getHouseList();

        model.addAttribute("houseList", houseList);
        return "houselist.html";
    }
ß
    @GetMapping("/house/optionSearch")
    public String search(
            @RequestParam(value = "option1", required = false) String option1,
            @RequestParam(value = "option2", required = false) String option2,
            @RequestParam(value = "option3", required = false) String option3) {

        /*
        List<HouseListDto> houseListDtoList = houseService.searchPosts(option1);
        List<HouseListDto> houseListDtoList = houseService.searchPosts(option2);
        List<HouseListDto> houseListDtoList = houseService.searchPosts(option3);

        model.addAttribute("houseListDtoList", houseListDtoList);
        */

        return "house/optionlist.html";
    }

    // 아래 참고
    /*
    @GetMapping("args")
    public ResponseEntity<?> getArgs(@RequestParam(value = "msg") String msg, @RequestParam(value = "msg2") String msg2) {

    return new ResponseEntity<>(msg + " / " + msg2, HttpStatus.OK);
    }
     */

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
