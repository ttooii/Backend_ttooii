package com.toyproject.realty.service;

import com.toyproject.realty.dto.HouseDto;
import com.toyproject.realty.entity.House;
import com.toyproject.realty.repository.HouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true) // 구동 실패 시 Rollback 할 수 있도록 하는 안전장치
@AllArgsConstructor
public class HouseService {

    private HouseRepository houseRepository;

    @Transactional
    public Long createHouse(HouseDto houseDto) {
        House house = houseDto.toEntity();
        houseRepository.save(house);

        return house.getHouseId();
    }

    @Transactional
    public int houseUpdateHit(String houseId) {
        return houseRepository.updateHit(houseId);
    }

//    public Object getHouseList(Pageable pageable) {
//
//    }
//
    @Transactional
    public List<HouseDto> getHouseList() {
        List<House> houseEntities = houseRepository.findAll();
        List<HouseDto> houseDtoList = new ArrayList<>();

        for(House houseEntity : houseEntities) {
            HouseDto houseDto = HouseDto.builder()
                    .houseId(houseEntity.getHouseId())
                    .transactionType(houseEntity.getTransactionType())
                    .exclusiveArea(houseEntity.getExclusiveArea())
                    .floor(houseEntity.getFloor())
                    .totalFloor(houseEntity.getTotalFloor())
                    .marketValue(houseEntity.getMarketValue())
                    .roomCount(houseEntity.getRoomCount())
                    .administrationCost(houseEntity.getAdministrationCost())
                    .bathroomCount(houseEntity.getBathroomCount())
                    .direction(houseEntity.getDirection())
                    .heatingSystem(houseEntity.getHeatingSystem())
                    .title(houseEntity.getTitle())
                    .content(houseEntity.getContent())
                    .landArea(houseEntity.getLandArea())
                    .parkingCount(houseEntity.getParkingCount())
                    .purpose(houseEntity.getPurpose())
                    .confirmation(houseEntity.getConfirmation())
                    .build();

            houseDtoList.add(houseDto);
        }

        return houseDtoList;
    }
}
