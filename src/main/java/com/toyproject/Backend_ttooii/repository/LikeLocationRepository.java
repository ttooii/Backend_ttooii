package com.toyproject.Backend_ttooii.repository;

import com.toyproject.Backend_ttooii.entity.LikeLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeLocationRepository extends JpaRepository<LikeLocation, Long> {

    List<LikeLocation> findByUserId(String userId);

}
