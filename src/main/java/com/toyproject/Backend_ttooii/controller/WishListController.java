package com.toyproject.Backend_ttooii.controller;

import com.toyproject.Backend_ttooii.dto.HouseListDto;
import com.toyproject.Backend_ttooii.dto.WishListDto;
import com.toyproject.Backend_ttooii.entity.Board;
import com.toyproject.Backend_ttooii.entity.Wishlist;
import com.toyproject.Backend_ttooii.service.WishListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@Api (tags={"집 위시리스트 API"})
@ApiImplicitParams({
        @ApiImplicitParam(name = "title", value = "제목", required = true),
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
        @ApiImplicitParam(name = "confirmation", value = "확인사항", required = true),
        @ApiImplicitParam(name = "registrant", value = "등록한 중개자 ID", required = true)})
public class WishListController {

    private WishListService wishListService;


    @ApiOperation(value="장바구니 list 출력")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "wishList", value = "장바구니 list"),
        @ApiImplicitParam(name = "totalPage", value = "페이지 총수 ")
    })
    @GetMapping("/wishlist/list")
    public Page<Wishlist> list(Model model,@RequestParam(required = false, defaultValue = "0", value = "page") int page) {
        Page<Wishlist> wishList = wishListService.getWishList(page);
        int totalPage=wishList.getTotalPages();
        model.addAttribute("wishList",wishList.getTotalPages());
        model.addAttribute("totalPage",totalPage);
        return wishList;
    }

    @ApiOperation(value="장바구니 no번째 wishlist 삭제")
    @DeleteMapping("/wishlist/delete/{no}")
    public void delete(@PathVariable Long no) {
        wishListService.delete(no);
    }

    @ApiOperation(value="장바구니 저장/ house 정보 모든 것을 넘겨줘야 함")
    @PostMapping("/wishlist/save")
    public void save( @RequestBody HouseListDto houseDto){
        wishListService.saveWishList(houseDto);
    }

}
