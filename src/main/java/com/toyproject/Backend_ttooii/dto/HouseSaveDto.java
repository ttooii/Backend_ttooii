package com.toyproject.Backend_ttooii.dto;

import com.toyproject.Backend_ttooii.entity.House;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseSaveDto {

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
    private String location;
    private String serviceType;
    private int monthlyExpenses;
    private String registrant;

    public House toEntity() {
        return House.builder()
                .houseId(houseId)
                .transactionType(transactionType)
                .landArea(landArea)
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
                .location(location)
                .serviceType(serviceType)
                .monthlyExpenses(monthlyExpenses)
                .registrant(registrant)
                .build();
    }

    @Builder
    public HouseSaveDto() {
        this.houseId = houseId;
        this.transactionType = transactionType;
        this.landArea = landArea;
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
        this.location = location;
        this.serviceType = serviceType;
        this.monthlyExpenses = monthlyExpenses;
        this.registrant=registrant;
    }
}
