package com.toyproject.Backend_ttooii.controller;

import com.toyproject.Backend_ttooii.dto.HouseListDto;
import com.toyproject.Backend_ttooii.dto.HouseSaveDto;
import com.toyproject.Backend_ttooii.entity.House;
import com.toyproject.Backend_ttooii.service.HouseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class HouseController {

    private HouseService houseService;


    @GetMapping("/house/add")
    public String createHouseForm(Model model){
        model.addAttribute("houseForm",new HouseSaveDto());
        return "houseAdd";
    }

    @ApiOperation(value = "방 등록", notes = "성공 시 방 등록에 성공합니다.")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string"),
                    @ApiImplicitParam(name = "content", value = "내용", required = true, dataType = "string"),
                    @ApiImplicitParam(name = "serviceType", value = "건물 종류", required = true, dataType = "string"),
                    @ApiImplicitParam(name = "location", value = "주소", required = true, dataType = "string"),
                    @ApiImplicitParam(name = "transactionType", value = "거래 종류", required = true, dataType = "string"),
                    @ApiImplicitParam(name = "deposit", value = "보증금", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "monthlyExpenses", value = "월세", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "landArea", value = "건물 크기", required = true, dataType = "float"),
                    @ApiImplicitParam(name = "heatingSystem", value = "난방 종류", required = true, dataType = "string"),
                    @ApiImplicitParam(name = "movesInDates", value = "입주 가능일", required = true, dataType = "string"),
                    @ApiImplicitParam(name = "floor", value = "전체 층수", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "totalFloor", value = "건물 층수", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "administrationCost", value = "관리비", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "bathroomCount", value = "화장실 개수", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "parkingCount", value = "주차장 개수", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "direction", value = "집 방향", required = true, dataType = "string"),
                    @ApiImplicitParam(name = "member", value = "등록한 중개자 ID", required = true, dataType = "string")})
    @PostMapping("/house/add")
    public String createHouse(@Valid HouseSaveDto houseSaveDto, BindingResult result, Authentication authentication) {
        if(result.hasErrors()){

            return "houseAdd";
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
    @GetMapping(value = "/house/list", produces = "application/json; charset=utf8")
    public Page<House> list(Model model, @RequestParam(required = false, defaultValue = "0", value = "page") int page) {
        /*
        List<HouseListDto> houseList = houseService.getHouseList(pageNum);
        Integer[] pageList = houseService.getPageList(pageNum);
       */
        Page<House> houseList = houseService.getPageList(page);

        int totalPage = houseList.getTotalPages();
        model.addAttribute("houseList", houseList.getTotalPages());
        model.addAttribute("totalPage", totalPage);

        return houseList;
    }

    // houseId 당 조회
    @GetMapping(value = "/house/{id}", produces = "application/json; charset=utf8")
    public HouseListDto detail(@PathVariable("id") String houseId, Model model) {
        HouseListDto houseListDto = houseService.getHouseId(houseId);
        model.addAttribute("post", houseListDto);

        return houseListDto;
    }

    // 지역으로 방 목록 조회
    @GetMapping(value = "/house/addressSearch", produces = "application/json; charset=utf8")
    public List<HouseListDto> addressSearch(@RequestParam(value = "address", required = false) String address, Model model) {

        List<HouseListDto> houseListDtoList = new ArrayList<HouseListDto>();
        houseListDtoList.addAll(houseService.searchLocationHouse(address));

        model.addAttribute("houseListDtoList", houseListDtoList);

        return houseListDtoList;
    }


    // 옵션으로 방 목록 조회
    @GetMapping(value = "/house/optionSearch", produces = "application/json; charset=utf8")
    public List<HouseListDto> optionSearch(
            @RequestParam(value = "option1", required = false) String option1,
            @RequestParam(value = "option2", required = false) String option2,
            @RequestParam(value = "option3", required = false) String option3, Model model) {

        List<HouseListDto> houseListDtoList = new ArrayList<>();
        houseListDtoList.addAll(houseService.searchServiceTypeHouse(option1));
        houseListDtoList.addAll(houseService.searchTransactionTypeHouse(option2));
        houseListDtoList.addAll(houseService.searchMonthlyExpensesHouse(option3));

        model.addAttribute("houseListDtoList", houseListDtoList);

        return houseListDtoList;
    }

    // 방 리스트에 이미지 보이게 만들기
}