package com.toyproject.realty.dto;

import lombok.Builder;

import java.util.Date;

public class HouseDto {

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
    private String movesInDates;
    private Date completionApproval;
    private int hit;
    private int wishCount;
    private String title;
    private String content;
    private int landArea;
    private int parkingCount;
    private String purpose;
    private int confirmation;
    private String deletion;


    @Builder
    public HouseDto(String houseId, String transactionType, Float exclusiveArea, int floor, int totalFloor, int marketValue, int roomCount, int administrationCost, int bathroomCount, String direction, String heatingSystem, String movesInDates, Date completionApproval, int hit, int wishCount, String title, String content, int landArea, int parkingCount, String purpose, int confirmation, String deletion) {
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
        this.movesInDates = movesInDates;
        this.completionApproval = completionApproval;
        this.hit = hit;
        this.wishCount = wishCount;
        this.title = title;
        this.content = content;
        this.landArea = landArea;
        this.parkingCount = parkingCount;
        this.purpose = purpose;
        this.confirmation = confirmation;
        this.deletion = deletion;
    }
}
