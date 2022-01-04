package com.toyproject.Backend_ttooii.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "notice")
public class Notice extends TimeEntity  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long noticeId;

    @Column(length = 20, nullable = false)
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Notice(Long noticeId, String title, String content, String writer) {
        this.noticeId = noticeId;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}

