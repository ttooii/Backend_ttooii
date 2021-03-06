package com.toyproject.Backend_ttooii.repository;

import com.toyproject.Backend_ttooii.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, String> {

    @Modifying
    @Query("update House h set h.hit = h.hit + 1 where h.houseId = :houseId")
    int updateHit(String houseId);


    List<House> findByLocationContaining(String keyword);

    List<House> findByServiceTypeContaining(String keyword);

    List<House> findByTransactionTypeContaining(String keyword);

    List<House> findByMonthlyExpensesContaining(String keyword);

    List<House> findAllByLandAreaBetween(float area1, float area2);

    List<House> findByAdministrationCost(String keyword);
}
