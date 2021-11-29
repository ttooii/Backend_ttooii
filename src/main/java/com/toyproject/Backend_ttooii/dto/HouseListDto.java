package com.toyproject.Backend_ttooii.dto;

import com.toyproject.Backend_ttooii.entity.House;
import lombok.Builder;

import java.util.Date;

public class HouseListDto {

    private String houseId;
    private String transactionType;
    private int floor;
    private int totalFloor;
    private int roomCount;
    private int administrationCost;
    private int bathroomCount;
    private String direction;
    private String heatingSystem;
    private String title;
    private String content;
    private int parkingCount;
    private String movesInDates;
    private Date completionApproval;
    private String location;
    private String serviceType;
    private int monthlyExpenses;
    private String registrant;
    private float landArea;

    public House toEntity() {
        return House.builder()
                .houseId(houseId)
                .transactionType(transactionType)
                .floor(floor)
                .totalFloor(totalFloor)
                .roomCount(roomCount)
                .administrationCost(administrationCost)
                .bathroomCount(bathroomCount)
                .direction(direction)
                .heatingSystem(heatingSystem)
                .title(title)
                .content(content)
                .landArea(landArea)
                .parkingCount(parkingCount)
                .movesInDates(movesInDates)
                .completionApproval(completionApproval)
                .location(location)
                .serviceType(serviceType)
                .monthlyExpenses(monthlyExpenses)
                .registrant(registrant)
                .build();
    }

    @Builder
    public HouseListDto(String registrant,String houseId, String transactionType, int floor, int totalFloor, int roomCount, int administrationCost, int bathroomCount, String direction, String heatingSystem, String title, String content, float landArea, int parkingCount, String purpose, int confirmation, String movesInDates, Date completionApproval, String location, String serviceType, int monthlyExpenses) {
        this.registrant=registrant;
        this.houseId = houseId;
        this.transactionType = transactionType;
        this.floor = floor;
        this.totalFloor = totalFloor;
        this.roomCount = roomCount;
        this.administrationCost = administrationCost;
        this.bathroomCount = bathroomCount;
        this.direction = direction;
        this.heatingSystem = heatingSystem;
        this.title = title;
        this.content = content;
        this.landArea = landArea;
        this.parkingCount = parkingCount;
        this.movesInDates = movesInDates;
        this.completionApproval = completionApproval;
        this.location = location;
        this.serviceType = serviceType;
        this.monthlyExpenses = monthlyExpenses;
    }
}
