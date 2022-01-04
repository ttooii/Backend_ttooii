package com.toyproject.Backend_ttooii.service;

import com.toyproject.Backend_ttooii.dto.BoardDto;
import com.toyproject.Backend_ttooii.entity.Board;
import com.toyproject.Backend_ttooii.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;
    private static final int BLOCK_PAGE_NUM_COUNT = 10;
    private static final int PAGE_COUNT = 10;

    @Transactional
    public Page<Board> getBoardList(int page){
        return boardRepository.findAll(PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "boardId")));
    }

    @Transactional
    public Long savePost(BoardDto boardDto , Authentication authentication) {
        if(authentication.getName().length()>20){
            boardDto.setWriter(authentication.getName().substring(0,19));
        }
        else{
            boardDto.setWriter(authentication.getName());
        }

        return boardRepository.save(boardDto.toEntity()).getBoardId();
    }

    @Transactional
    public Long updatePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getBoardId();
    }


    @Transactional
    public BoardDto getPost(Long id) {
        Optional<Board> boardWrapper = boardRepository.findById(id);
        Board boardEntity = boardWrapper.get();

        return BoardDto.builder()
                .boardId(boardEntity.getBoardId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .writer(boardEntity.getWriter())
                .build();
    }

    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }
    
}
