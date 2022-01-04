package com.toyproject.Backend_ttooii.entity;

import lombok.*;
import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="board")
public class Board extends TimeEntity {
    @Id
    @Column(name = "board_id", unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long boardId;

    @Column(length = 20, nullable = false)
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Board(Long boardId, String title, String content, String writer) {
        this.boardId = boardId;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}

