package com.toyproject.Backend_ttooii.repository;

import com.toyproject.Backend_ttooii.entity.Wishlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<Wishlist,Long> {
    Page<Wishlist> findByUserId(String userId, Pageable pageable);
}
