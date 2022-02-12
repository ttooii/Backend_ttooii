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
        @ApiImplicitParam(name = "noticeId", value = "글번호", required = true),
        @ApiImplicitParam(name = "title", value = "글제목", required = true),
        @ApiImplicitParam(name = "writer", value = "글쓴이", required = true),
        @ApiImplicitParam(name = "content", value = "내용", required = true),
        @ApiImplicitParam(name = "createdAt", value = "생성날짜/시간", required = true),
        @ApiImplicitParam(name = "modifiedAt", value = "변경날짜/시간", required = true)})

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
        model.addAttribute("noticeList",noticeList.getContent());
        model.addAttribute("totalPage",totalPage);
        return noticeList;
    }

    @ApiOperation(value = "공지사항 글 생성")
    @ApiImplicitParam(name = "noticeDto", value = "공지사항 정보/title, content만 필요/ writer는 로그인한 아이디로 자동 저장,createAt과 modifiedAt도 자동생성및 저장")
    @GetMapping("/notice/write")
    public String write() {
        return "/notice/write.html";
    }

    @PostMapping("/notice/write")
    public Long write(NoticeDto noticeDto,Authentication authentication) {
        return noticeService.savePost(noticeDto,authentication);
    }

    @ApiOperation(value="공지사항 no.글 수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noticeDto", value = "공지사항 정보/title과 content만 수정 가능"),
            @ApiImplicitParam(name = "no", value = "글 번호")})
    @GetMapping("/notice/edit/{no}")
    public void edit(@PathVariable("no") Long no, Model model) {
        NoticeDto noticeDto = noticeService.getPost(no);
        model.addAttribute("noticeDto", noticeDto);
    }

    @ApiOperation(value="공지사항 no.글 수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noticeDto", value = "공지사항 정보"),
            @ApiImplicitParam(name = "no", value = "글 번호")})
    @PutMapping("/notice/edit/{no}")
    public Long update(NoticeDto noticeDto) {
        return noticeService.updatePost(noticeDto);
    }
    @ApiOperation(value="공지사항 no.글 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noticeDto", value = "공지사항 정보"),
            @ApiImplicitParam(name = "no", value = "글 번호")})
    @DeleteMapping("/notice/{no}")
    public void delete(@PathVariable("no") Long no) {
        noticeService.deletePost(no);
    }

    @ApiOperation(value="공지사항 no.글 출력")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "noticeDto", value = "공지사항 정보"),
    @ApiImplicitParam(name = "no", value = "글 번호")})
    @GetMapping("/notice/{no}")
    public void detail(@PathVariable("no") Long no, Model model) {
        NoticeDto noticeDto = noticeService.getPost(no);
        model.addAttribute("noticeDto", noticeDto);
    }
}