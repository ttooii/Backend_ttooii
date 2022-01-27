package com.toyproject.Backend_ttooii.controller;
import com.toyproject.Backend_ttooii.dto.BoardDto;
import com.toyproject.Backend_ttooii.entity.Board;
import com.toyproject.Backend_ttooii.service.BoardService;
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

@Controller
@AllArgsConstructor
@Api(tags = {"게시판 API"})
@ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "글번호", required = true),
        @ApiImplicitParam(name = "title", value = "글제목", required = true),
        @ApiImplicitParam(name = "writer", value = "글쓴이", required = true),
        @ApiImplicitParam(name = "content", value = "내용", required = true),
        @ApiImplicitParam(name = "created_at", value = "생성날짜/시간", required = true),
        @ApiImplicitParam(name = "modified_at", value = "변경날짜/시간", required = true)})

public class BoardController {
    private BoardService boardService;

    @ApiOperation(value="게시판 글 list 출력")
    @ApiImplicitParam(name = "BoardList", value = "게시판 list")
    @GetMapping("/board/list")
    public Page<Board> list(Model model, @RequestParam(required = false, defaultValue = "0", value = "page") int page) {
        Page<Board> boardList=boardService.getBoardList(page);
        int totalPage=boardList.getTotalPages();
        model.addAttribute("boardList",boardList.getTotalPages());
        model.addAttribute("totalPage",totalPage);
        return boardList;
    }

    @ApiOperation(value = "게시판 글 생성")
    @ApiImplicitParam(name = "BoardDto", value = "게시판 정보")
    @GetMapping("/board/write")
    public String write() {
        return "/board/write.html";
    }

    @PostMapping("/board/write")
    public String write(BoardDto boardDto, Authentication authentication) {
        boardService.savePost(boardDto,authentication);
        return "redirect:/board/list";
    }

    @ApiOperation(value="게시판 no.글 수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "BoardDto", value = "게시판 정보"),
            @ApiImplicitParam(name = "no", value = "글 번호")})
    @GetMapping("/board/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        BoardDto boardDto = boardService.getPost(no);
        model.addAttribute("BoardDto", boardDto);
        System.out.println(boardDto);
        return "/board/update";
    }

    @ApiOperation(value="게시판 no.글 수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "BoardDto", value = "게시판 정보"),
            @ApiImplicitParam(name = "no", value = "글 번호")})
    @PutMapping("/board/edit/{no}")
    public String update(BoardDto boardDto) {
        boardService.updatePost(boardDto);

        return "redirect:/board/list";
    }

    @ApiOperation(value="게시판 no.글 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "BoardDto", value = "게시판 정보"),
            @ApiImplicitParam(name = "no", value = "글 번호")})
    @DeleteMapping("/board/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);
        return "redirect:/board/list";
    }

    @ApiOperation(value="게시판 no.글 출력")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "BoardDto", value = "게시판 정보"),
            @ApiImplicitParam(name = "no", value = "글 번호")})
    @GetMapping("/board/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {
        BoardDto boardDto = boardService.getPost(no);
        model.addAttribute("BoardDto",boardDto);
        return "/board/detail";
    }
}
