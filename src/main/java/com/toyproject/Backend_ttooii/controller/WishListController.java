package com.toyproject.Backend_ttooii.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

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

}
