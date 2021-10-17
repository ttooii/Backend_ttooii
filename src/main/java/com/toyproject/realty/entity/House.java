package com.toyproject.realty.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "HOUSE")
public class House {

    @Id
    @Column(name = "house_id", length = 5, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    private Long houseId;

    @Column(name = "transaction_type", length = 20)
    @NotNull
    private String transactionType;

    @JsonIgnore
    @Column(name = "exclusive_area")
    @NotNull
    private Float exclusiveArea;

    @Column(name = "floor")
    @NotNull
    private int floor;

    @Column(name = "total_floor")
    @NotNull
    private int totalFloor;


    @Column(name = "market_value")
    @NotNull
    private int marketValue;

    @Column(name = "room_count")
    @NotNull
    private int roomCount;

    @Column(name = "administration_cost")
    @NotNull
    private int administrationCost;

    @Column(name = "bathroom_count")
    @NotNull
    private int bathroomCount;

    @Column(name = "direction")
    @NotNull
    private String direction;

    @Column(name = "heating_system")
    @NotNull
    private String heatingSystem;

    @Column(name = "moves_in_dates")
    @NotNull
    private String movesInDates;

    @Column(name = "completion_approval")
    @NotNull
    private Date completionApproval;

    @Column(name = "hit")
    @NotNull
    private int hit;

    @Column(name = "wish_count")
    @NotNull
    private int wishCount;

    @Column(name = "title",  length = 50)
    @NotNull
    private String title;

    @Column(name = "content",  length = 1000)
    @NotNull
    private String content;

    @Column(name = "land_area")
    @NotNull
    private int landArea;

    @Column(name = "parking_count")
    @NotNull
    private int parkingCount;

    @Column(name = "purpose", length = 50)
    @NotNull
    private String purpose;

    @Column(name = "confirmation")
    @NotNull
    private int confirmation;

    @Column(name = "deletion")
    @NotNull
    private String deletion;

    @Builder
    public House(Long houseId, String transactionType, Float exclusiveArea, int floor, int totalFloor, int marketValue, int roomCount, int administrationCost, int bathroomCount, String direction, String heatingSystem, String movesInDates, Date completionApproval, int hit, int wishCount, String title, String content, int landArea, int parkingCount, String purpose, int confirmation, String deletion) {
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
