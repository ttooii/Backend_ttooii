package com.toyproject.realty.service;

import com.toyproject.realty.dto.NoticeDto;
import com.toyproject.realty.entity.Notice;
import com.toyproject.realty.repository.NoticeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class NoticeService {
    private NoticeRepository noticeRepository;

    @Transactional
    public List<NoticeDto> getNoticeList() {
        List<Notice> notices = noticeRepository.findAll();
        List<NoticeDto> noticeDtoList = new ArrayList<>();
        for (Notice notice : notices) {
            NoticeDto noticeDto = NoticeDto.builder()
                    .id(notice.getId())
                    .title(notice.getTitle())
                    .content(notice.getContent())
                    .writer(notice.getWriter())
                    .created_at(notice.getCreated_at())
                    .build();

            noticeDtoList.add(noticeDto);
        }
        return noticeDtoList;
    }
    @Transactional
    public Long savePost(NoticeDto noticeDto) {
        return noticeRepository.save(noticeDto.toEntity()).getId();
    }
    @Transactional
    public NoticeDto getPost(Long id) {
        Optional<Notice> noticeWrapper = noticeRepository.findById(id);
        Notice boardEntity = noticeWrapper.get();

        return NoticeDto.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .writer(boardEntity.getWriter())
                .created_at(boardEntity.getCreated_at())
                .build();
    }


    @Transactional
    public void deletePost(Long id) {
        noticeRepository.deleteById(id);
    }
}