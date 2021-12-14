package com.toyproject.Backend_ttooii.repository;

import com.toyproject.Backend_ttooii.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}