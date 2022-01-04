package com.toyproject.Backend_ttooii.service;

import com.toyproject.Backend_ttooii.dto.NoticeDto;
import com.toyproject.Backend_ttooii.entity.Notice;
import com.toyproject.Backend_ttooii.repository.MemberRepository;
import com.toyproject.Backend_ttooii.repository.NoticeRepository;
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

@AllArgsConstructor
@Service
public class NoticeService {
    private NoticeRepository noticeRepository;
    private  MemberRepository memberRepository;

    @Transactional
    public Page<Notice> getNoticeList(int page){
        return noticeRepository.findAll(PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "boardId")));
    }

    @Transactional
    public Long savePost(NoticeDto noticeDto, Authentication authentication) {
        if(authentication.getName().length()>20){
            noticeDto.setWriter(authentication.getName().substring(0,19));
        }
        else{
            noticeDto.setWriter(authentication.getName());
        }
        return noticeRepository.save(noticeDto.toEntity()).getNoticeId();
    }

    @Transactional
    public Long updatePost(NoticeDto noticeDto){
        return  noticeRepository.save(noticeDto.toEntity()).getNoticeId();
    }

    @Transactional
    public NoticeDto getPost(Long id) {
        Optional<Notice> noticeWrapper = noticeRepository.findById(id);
        Notice boardEntity = noticeWrapper.get();

        return NoticeDto.builder()
                .noticeId(boardEntity.getNoticeId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .writer(boardEntity.getWriter())
                .build();
    }


    @Transactional
    public void deletePost(Long id) {
        noticeRepository.deleteById(id);
    }
}