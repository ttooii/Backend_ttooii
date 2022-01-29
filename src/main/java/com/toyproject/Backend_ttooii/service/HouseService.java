package com.toyproject.Backend_ttooii.service;

import com.toyproject.Backend_ttooii.dto.HouseListDto;
import com.toyproject.Backend_ttooii.dto.HouseSaveDto;
import com.toyproject.Backend_ttooii.entity.House;
import com.toyproject.Backend_ttooii.entity.Inclusive;
import com.toyproject.Backend_ttooii.repository.HouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true) // 구동 실패 시 Rollback 할 수 있도록 하는 안전장치
@AllArgsConstructor
public class HouseService {

    private HouseRepository houseRepository;

    private static final int BLOCK_PAGE_NUM_COUNT = 8;
    private static final int PAGE_HOUSE_COUNT = 8;

    @Transactional
    public String createHouse(HouseListDto houseDto) {
        House house = houseDto.toEntity();
        houseRepository.save(house);

        return house.getHouseId();
    }

    @Transactional
    public int houseUpdateHit(String houseId) {
        return houseRepository.updateHit(houseId);
    }

    @Transactional
    public String save(HouseSaveDto requestDto) {

        return houseRepository.save(requestDto.toEntity()).getHouseId();
    }

    @Transactional
    public List<HouseListDto> getHouseList(Integer pageNum) {
        Page<House> page = houseRepository.findAll(PageRequest.of(
                pageNum - 1, PAGE_HOUSE_COUNT, Sort.by(Sort.Direction.ASC, "houseId")
        ));

        List<House> houses = page.getContent();
        List<HouseListDto> houseDtoList = new ArrayList<>();

        for (House house : houses) {
            houseDtoList.add(this.convertEntityToDto(house));
        }

        return houseDtoList;
    }

    public Long getHouseCount() {

        return houseRepository.count();
    }

    public Page<House> getPageList(int page) {
        /*
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

        // 총 매물 수
        Double housesTotalCount = Double.valueOf(this.getHouseCount());

        // 총 매물 기준으로 계산한 마지막 페이지 번호 계산
        Integer totalLastPageNum = (int) (Math.ceil(housesTotalCount / PAGE_HOUSE_COUNT));

        // 현재 페이지 기준으로 계산한 마지막 페이지 번호 계산
        Integer blockLastPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
                ? curPageNum + BLOCK_PAGE_NUM_COUNT
                : totalLastPageNum;

        curPageNum = (curPageNum <= 3) ? 1 : curPageNum - 2;

        for (int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {

            pageList[idx] = val;
        }

        return pageList;
         */

        return houseRepository.findAll(PageRequest.of(page, 200000, Sort.by(Sort.Direction.DESC, "houseId")));
    }

    @Transactional
    public HouseListDto getHouseId(String houseId) {
        House house = houseRepository.findById(houseId).get();

        HouseListDto houseListDto = HouseListDto.builder()
                .houseId(house.getHouseId())
                .transactionType(house.getTransactionType())
                .floor(house.getFloor())
                .totalFloor(house.getTotalFloor())
                .roomCount(house.getRoomCount())
                .administrationCost(house.getAdministrationCost())
                .direction(house.getDirection())
                .title(house.getTitle())
                .content(house.getContent())
                .landArea(house.getLandArea())
                .location(house.getLocation())
                .serviceType(house.getServiceType())
                .monthlyExpenses(house.getMonthlyExpenses())
                .deposit(house.getDeposit())
                .build();

        return houseListDto;
    }

    public List<HouseListDto> searchLocationHouse(String keyword) {
        List<House> houseEntities = houseRepository.findByLocationContaining(keyword);
        List<HouseListDto> houseDtoList = new ArrayList<>();

        if (houseEntities.isEmpty()) return houseDtoList;

        for (House houseEntity : houseEntities) {
            houseDtoList.add(this.convertEntityToDto(houseEntity));
        }

        return houseDtoList;
    }

    public List<HouseListDto> searchServiceTypeHouse(String keyword) {
        List<House> houseEntities = houseRepository.findByServiceTypeContaining(keyword);
        List<HouseListDto> houseDtoList = new ArrayList<>();

        if (houseEntities.isEmpty()) return houseDtoList;

        for (House houseEntity : houseEntities) {
            houseDtoList.add(this.convertEntityToDto(houseEntity));
        }

        return houseDtoList;
    }

    public List<HouseListDto> searchTransactionTypeHouse(String keyword) {
        List<House> houseEntities = houseRepository.findByTransactionTypeContaining(keyword);
        List<HouseListDto> houseDtoList = new ArrayList<>();

        if (houseEntities.isEmpty()) return houseDtoList;

        for (House houseEntity : houseEntities) {
            houseDtoList.add(this.convertEntityToDto(houseEntity));
        }

        return houseDtoList;
    }

    public List<HouseListDto> searchMonthlyExpensesHouse(String keyword) {
        List<House> houseEntities = houseRepository.findByMonthlyExpensesContaining(keyword);
        List<HouseListDto> houseDtoList = new ArrayList<>();

        if (houseEntities.isEmpty()) return houseDtoList;

        for (House houseEntity : houseEntities) {
            houseDtoList.add(this.convertEntityToDto(houseEntity));
        }

        return houseDtoList;
    }

    private HouseListDto convertEntityToDto(House houseEntity) {

        return HouseListDto.builder()
                .houseId(houseEntity.getHouseId())
                .transactionType(houseEntity.getTransactionType())
                .floor(houseEntity.getFloor())
                .totalFloor(houseEntity.getTotalFloor())
                .roomCount(houseEntity.getRoomCount())
                .administrationCost(houseEntity.getAdministrationCost())
                .direction(houseEntity.getDirection())
                .title(houseEntity.getTitle())
                .content(houseEntity.getContent())
                .landArea(houseEntity.getLandArea())
                .location(houseEntity.getLocation())
                .serviceType(houseEntity.getServiceType())
                .monthlyExpenses(houseEntity.getMonthlyExpenses())
                .build();
    }
}
