package com.toyproject.realty.repository;

import com.toyproject.realty.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
