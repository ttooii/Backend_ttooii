package com.toyproject.realty.repository;

import com.toyproject.realty.entity.login.Member;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String userEmail);
}