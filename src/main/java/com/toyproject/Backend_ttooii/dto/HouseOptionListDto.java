package com.toyproject.Backend_ttooii.dto;

import com.toyproject.Backend_ttooii.entity.House;
import com.toyproject.Backend_ttooii.entity.Inclusive;
import lombok.Builder;

public class HouseOptionListDto {

    private House houseId;
    private int bathroomCount;
    private int parkingCount;
    private int heatingSystem;

    public Inclusive toEntity() {

        return Inclusive.builder()
                .houseId(houseId)
                .bathroomCount(bathroomCount)
                .parkingCount(parkingCount)
                .heatingSystem(heatingSystem)
                .build();
    }

    @Builder
    public HouseOptionListDto(House houseId, int bathroomCount, int parkingCount, int heatingSystem) {

        this.houseId = houseId;
        this.bathroomCount = bathroomCount;
        this.parkingCount = parkingCount;
        this.heatingSystem = heatingSystem;
    }
}
