package com.toyproject.Backend_ttooii.dto;

import com.toyproject.Backend_ttooii.entity.House;
import com.toyproject.Backend_ttooii.entity.Inclusive;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;
@Getter
public class HouseListDto {

    private String houseId;
    private String direction;
    private String title;
    private String content;
    private String movesInDates;
    private String location;
    private String registrant;
    private Date completionApproval;
    //private Inclusive inclusive;
    private String transactionType;
    private String serviceType;
    private String monthlyExpenses;
    private int floor;
    private int totalFloor;
    private int roomCount;
    private int administrationCost;
    private int deposit;
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
                .deposit(deposit)
                .monthlyExpenses(monthlyExpenses)
                .registrant(registrant)
                //.inclusive(inclusive)
                .build();
    }

    @Builder
    public HouseListDto(String registrant, String houseId, String direction, String title, String content, String movesInDates, String location,
                        String transactionType, int floor, int totalFloor, int roomCount, int administrationCost, String serviceType, int deposit, String monthlyExpenses,
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
        this.deposit = deposit;
        this.monthlyExpenses = monthlyExpenses;
        //this.inclusive = inclusive;
    }
}
