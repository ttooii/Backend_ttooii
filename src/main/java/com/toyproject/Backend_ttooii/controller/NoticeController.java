package com.toyproject.Backend_ttooii.controller;

import com.toyproject.Backend_ttooii.dto.NoticeDto;
import com.toyproject.Backend_ttooii.entity.Notice;
import com.toyproject.Backend_ttooii.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"공지사항 API"})
@ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "글번호", required = true),
        @ApiImplicitParam(name = "title", value = "글제목", required = true),
        @ApiImplicitParam(name = "writer", value = "글쓴이", required = true),
        @ApiImplicitParam(name = "content", value = "내용", required = true),
        @ApiImplicitParam(name = "created_at", value = "생성날짜/시간", required = true),
        @ApiImplicitParam(name = "modified_at", value = "변경날짜/시간", required = true)})

@RestController
@AllArgsConstructor
public class NoticeController {
    private NoticeService noticeService;

    @ApiOperation(value="공지사항 글 list 출력")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noticeList", value = "공지사항 list"),
            @ApiImplicitParam(name = "totalPage", value = "총 페이지 수")})
    @GetMapping("/notice/list")
    public Page<Notice> list(Model model, @RequestParam(required = false, defaultValue = "0", value = "page") int page) {
        Page<Notice> noticeList=noticeService.getNoticeList(page);
        int totalPage=noticeList.getTotalPages();
        model.addAttribute("noticeList",noticeList.getTotalPages());
        model.addAttribute("totalPage",totalPage);
        return noticeList;
    }

    @ApiOperation(value = "공지사항 글 생성")
    @ApiImplicitParam(name = "noticeDto", value = "공지사항 정보")
    @GetMapping("/notice/write")
    public String write() {
        return "/notice/write.html";
    }

    @PostMapping("/notice/write")
    public String write(NoticeDto noticeDto,Authentication authentication) {
        noticeService.savePost(noticeDto,authentication);
        return "redirect:/notice/list";
    }

    @ApiOperation(value="공지사항 no.글 수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noticeDto", value = "공지사항 정보"),
            @ApiImplicitParam(name = "no", value = "글 번호")})
    @GetMapping("/notice/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        NoticeDto noticeDto = noticeService.getPost(no);
        model.addAttribute("noticeDto", noticeDto);
        System.out.println(noticeDto);
        return "/notice/update";
    }

    @ApiOperation(value="공지사항 no.글 수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noticeDto", value = "공지사항 정보"),
            @ApiImplicitParam(name = "no", value = "글 번호")})
    @PutMapping("/notice/edit/{no}")
    public String update(NoticeDto noticeDto) {
        noticeService.updatePost(noticeDto);
        return "redirect:/notice/list";
    }
    @ApiOperation(value="공지사항 no.글 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noticeDto", value = "공지사항 정보"),
            @ApiImplicitParam(name = "no", value = "글 번호")})
    @DeleteMapping("/notice/{no}")
    public String delete(@PathVariable("no") Long no) {
        noticeService.deletePost(no);
        return "redirect:/notice/list";
    }

    @ApiOperation(value="공지사항 no.글 출력")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "noticeDto", value = "공지사항 정보"),
    @ApiImplicitParam(name = "no", value = "글 번호")})
    @GetMapping("/notice/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {
        NoticeDto noticeDto = noticeService.getPost(no);
        model.addAttribute("noticeDto", noticeDto);
        return "/notice/detail";
    }
}