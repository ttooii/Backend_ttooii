package com.toyproject.realty.controller;

import com.toyproject.realty.dto.HouseListDto;
import com.toyproject.realty.dto.HouseSaveDto;
import com.toyproject.realty.dto.MemberDto;
import com.toyproject.realty.service.HouseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
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
    public String createHouse(@Valid HouseSaveDto houseSaveDto, BindingResult result, Authentication authentication) {
        if(result.hasErrors()){

            return "/houseAdd";
        }
        if(authentication.getName().length()>20){
            houseSaveDto.setRegistrant(authentication.getName().substring(0,19));
        }
        else{
            houseSaveDto.setRegistrant(authentication.getName());
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

    // 지역으로 방 목록 조회
    @GetMapping("/house/addressSearch")
    public String addressSearch(@RequestParam(value = "address", required = false) String address, Model model) {

        List<HouseListDto> houseListDtoList = new ArrayList<HouseListDto>();
        houseListDtoList.addAll(houseService.searchLocationHouse(address));

        model.addAttribute("houseListDtoList", houseListDtoList);

        return "houseAddressList.html";
    }


    // 옵션으로 방 목록 조회
    @GetMapping("/house/optionSearch")
    public String optionSearch(
            @RequestParam(value = "option1", required = false) String option1,
            @RequestParam(value = "option2", required = false) String option2,
            @RequestParam(value = "option3", required = false) String option3, Model model) {


        List<HouseListDto> houseListDtoList = new ArrayList<HouseListDto>();
        houseListDtoList.addAll(houseService.searchServiceTypeHouse(option1));
        houseListDtoList.addAll(houseService.searchTransactionTypeHouse(option2));
        houseListDtoList.addAll(houseService.searchMonthlyExpensesHouse(option3));

        model.addAttribute("houseListDtoList", houseListDtoList);

        return "houseOptionList.html";
    }

    // 방 리스트에 이미지 보이게 만들기

}
