package com.toyproject.Backend_ttooii.dto;

import com.toyproject.Backend_ttooii.entity.Notice;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeDto {
    private Long noticeId;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public Notice toEntity(){
        Notice notice = Notice.builder()
                .noticeId(noticeId)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return notice;
    }

    @Builder
    public NoticeDto(Long noticeId, String title, String content, String writer, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.noticeId =noticeId;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}