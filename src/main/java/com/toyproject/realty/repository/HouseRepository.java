package com.toyproject.realty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HouseRepository extends JpaRepository<House, String> {
}
