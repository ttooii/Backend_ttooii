package com.toyproject.Backend_ttooii.dto;

import com.toyproject.Backend_ttooii.entity.House;
import com.toyproject.Backend_ttooii.entity.Inclusive;
import lombok.Builder;

import java.util.Date;
import java.util.List;

public class HouseListDto {

    private String houseId;
    private String direction;
    private String title;
    private String content;
    private String movesInDates;
    private String location;
    private String registrant;
    private Date completionApproval;
    private Inclusive inclusive;
    private int transactionType;
    private int serviceType;
    private int floor;
    private int totalFloor;
    private int roomCount;
    private int administrationCost;
    private int monthlyExpenses;
    private float landArea;

    public House toEntity() {
        return House.builder()
                .houseId(houseId)
                .transactionType(transactionType)
                .floor(floor)
                .totalFloor(totalFloor)
                .roomCount(roomCount)
                .administrationCost(administrationCost)
                .direction(direction)
                .title(title)
                .content(content)
                .landArea(landArea)
                .movesInDates(movesInDates)
                .completionApproval(completionApproval)
                .location(location)
                .serviceType(serviceType)
                .monthlyExpenses(monthlyExpenses)
                .registrant(registrant)
                .inclusive(inclusive)
                .build();
    }

    @Builder
    public HouseListDto(String registrant, String houseId, String direction, String title, String content, String movesInDates, String location,
                        int transactionType, int floor, int totalFloor, int roomCount, int administrationCost, int serviceType, int monthlyExpenses,
                        float landArea, Date completionApproval, Inclusive inclusive) {

        this.registrant = registrant;
        this.houseId = houseId;
        this.transactionType = transactionType;
        this.floor = floor;
        this.totalFloor = totalFloor;
        this.roomCount = roomCount;
        this.administrationCost = administrationCost;
        this.direction = direction;
        this.title = title;
        this.content = content;
        this.landArea = landArea;
        this.movesInDates = movesInDates;
        this.completionApproval = completionApproval;
        this.location = location;
        this.serviceType = serviceType;
        this.monthlyExpenses = monthlyExpenses;
        this.inclusive = inclusive;
    }
}
