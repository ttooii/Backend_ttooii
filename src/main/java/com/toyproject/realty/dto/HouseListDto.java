package com.toyproject.realty.dto;

import com.toyproject.realty.entity.House;
import lombok.Builder;

import java.util.Date;

public class HouseListDto {

    private String houseId;
    private String transactionType;
    private Float exclusiveArea;
    private int floor;
    private int totalFloor;
    private int marketValue;
    private int roomCount;
    private int administrationCost;
    private int bathroomCount;
    private String direction;
    private String heatingSystem;
    private String title;
    private String content;
    private int landArea;
    private int parkingCount;
    private String purpose;
    private int confirmation;
    private String movesInDates;
    private Date completionApproval;
    private String location;
    private String serviceType;
    private int monthlyExpenses;


    public House toEntity() {
        return House.builder()
                .transactionType(transactionType)
                .exclusiveArea(exclusiveArea)
                .floor(floor)
                .totalFloor(totalFloor)
                .marketValue(marketValue)
                .roomCount(roomCount)
                .administrationCost(administrationCost)
                .bathroomCount(bathroomCount)
                .direction(direction)
                .heatingSystem(heatingSystem)
                .title(title)
                .content(content)
                .landArea(landArea)
                .parkingCount(parkingCount)
                .purpose(purpose)
                .confirmation(confirmation)
                .movesInDates(movesInDates)
                .completionApproval(completionApproval)
                .location(location)
                .serviceType(serviceType)
                .monthlyExpenses(monthlyExpenses)
                .build();
    }

    @Builder
    public HouseListDto(String houseId, String transactionType, Float exclusiveArea, int floor, int totalFloor, int marketValue, int roomCount, int administrationCost, int bathroomCount, String direction, String heatingSystem, String title, String content, int landArea, int parkingCount, String purpose, int confirmation, String movesInDates, Date completionApproval, String location, String serviceType, int monthlyExpenses) {
        this.houseId = houseId;
        this.transactionType = transactionType;
        this.exclusiveArea = exclusiveArea;
        this.floor = floor;
        this.totalFloor = totalFloor;
        this.marketValue = marketValue;
        this.roomCount = roomCount;
        this.administrationCost = administrationCost;
        this.bathroomCount = bathroomCount;
        this.direction = direction;
        this.heatingSystem = heatingSystem;
        this.title = title;
        this.content = content;
        this.landArea = landArea;
        this.parkingCount = parkingCount;
        this.purpose = purpose;
        this.confirmation = confirmation;
        this.movesInDates = movesInDates;
        this.completionApproval = completionApproval;
        this.location = location;
        this.serviceType = serviceType;
        this.monthlyExpenses = monthlyExpenses;
    }
}
