package com.toyproject.realty.service;

import com.toyproject.Backend_ttooii.repository.MemberRepository;
import com.toyproject.realty.dto.BoardDto;
import com.toyproject.realty.entity.Board;
import com.toyproject.realty.repository.BoardRepository;
// import com.toyproject.realty.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;
    private MemberRepository memberRepository;

    @Transactional
    public List<BoardDto> getBoardList() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        for (Board board : boards) {
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .build();

            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }
    @Transactional
    public Long savePost(BoardDto BoardDto ) {
        return boardRepository.save(BoardDto.toEntity()).getId();
    }
    @Transactional
    public BoardDto getPost(Long id) {
        Optional<Board> BoardWrapper = boardRepository.findById(id);
        Board boardEntity = BoardWrapper.get();

        return BoardDto.builder()
                .id(boardEntity.getId())
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