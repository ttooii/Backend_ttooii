package com.toyproject.realty.dto;

import com.toyproject.realty.entity.Board;
import com.toyproject.realty.entity.Notice;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {

    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;

    public Board toEntity(){
         Board board = Board.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return board;
    }

    @Builder
    public BoardDto(Long id, String title, String content, String writer, LocalDateTime created_at, LocalDateTime modified_at) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }
}
