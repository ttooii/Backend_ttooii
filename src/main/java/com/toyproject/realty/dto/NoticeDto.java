package com.toyproject.realty.dto;

import com.toyproject.realty.entity.Notice;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;

    public Notice toEntity(){
        Notice notice = Notice.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return notice;
    }

    @Builder
    public NoticeDto(Long id, String title, String content, String writer, LocalDateTime created_at, LocalDateTime modified_at) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }
}