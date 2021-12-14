package com.toyproject.Backend_ttooii.dto;

import com.toyproject.Backend_ttooii.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {

    private Long board_id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;

    public Board toEntity(){
         Board board = Board.builder()
                .board_id(board_id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return board;
    }

    @Builder
    public BoardDto(Long board_id, String title, String content, String writer, LocalDateTime created_at, LocalDateTime modified_at) {
        this.board_id =board_id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }
}
