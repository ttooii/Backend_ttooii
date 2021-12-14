package com.toyproject.Backend_ttooii.dto;

import com.toyproject.Backend_ttooii.entity.House;
import com.toyproject.Backend_ttooii.entity.Inclusive;
import com.toyproject.Backend_ttooii.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseSaveDto {

    private String houseId;
    private String direction;
    private String title;
    private String content;
    private String location;
    private String registrant;
    private Member member;
    private Inclusive inclusive;
    private float landArea;
    private int floor;
    private int totalFloor;
    private int deposit;
    private int administrationCost;
    private int parkingCount;
    private int bathroomCount;
    private int monthlyExpenses;
    private int heatingSystem;
    private int transactionType;
    private int serviceType;

    public House toEntity() {
        return House.builder()
                .houseId(houseId)
                .transactionType(transactionType)
                .floor(floor)
                .totalFloor(totalFloor)
                .administrationCost(administrationCost)
                .bathroomCount(bathroomCount)
                .direction(direction)
                .title(title)
                .content(content)
                .landArea(landArea)
                .location(location)
                .serviceType(serviceType)
                .monthlyExpenses(monthlyExpenses)
                .member(member)
                .registrant(registrant)
                .inclusive(inclusive)
                .build();
    }

    @Builder
    public HouseSaveDto() {
        this.houseId = houseId;
        this.transactionType = transactionType;
        this.landArea = landArea;
        this.floor = floor;
        this.totalFloor = totalFloor;
        this.administrationCost = administrationCost;
        this.bathroomCount = bathroomCount;
        this.direction = direction;
        this.heatingSystem = heatingSystem;
        this.title = title;
        this.content = content;
        this.landArea = landArea;
        this.parkingCount = parkingCount;
        this.location = location;
        this.serviceType = serviceType;
        this.monthlyExpenses = monthlyExpenses;
        this.member = member;
        this.registrant = registrant;
        this.inclusive = inclusive;
    }
}
