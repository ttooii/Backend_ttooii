package com.toyproject.Backend_ttooii.dto;

import com.toyproject.Backend_ttooii.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {

    private Long boardId;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public Board toEntity(){
         Board board = Board.builder()
                .boardId(boardId)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return board;
    }


    @Builder
    public BoardDto(Long boardId, String title, String content, String writer, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.boardId =boardId;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
