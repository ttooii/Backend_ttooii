package com.toyproject.Backend_ttooii.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "INCLUSIVE")
public class Inclusive {

    @Id
    @Column(name = "inclusive_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private String inclusiveId;

    @ManyToOne
    @JoinColumn(name = "fk_house_id")
    @NotNull
    private House houseId;

    @Column(name = "air_conditioner")
    @NotNull
    private int airConditioner;

    @Column(name = "refrigerator")
    @NotNull
    private int refrigerator;

    @Column(name = "parking_count")
    @NotNull
    private int parkingCount;

    @Column(name = "bathroom_count")
    @NotNull
    private int bathroomCount;

    @Column(name = "fire_alarm")
    @NotNull
    private int fireAlarm;

    @Column(name = "heating_system")
    @NotNull
    private int heatingSystem;

    @Column(name = "elevator")
    @NotNull
    private int elevator;

    @Column(name = "veranda")
    @NotNull
    private int veranda;

    @Column(name = "pet")
    @NotNull
    private int pet;

    @Builder
    public Inclusive(
            House houseId,
            int airConditioner, int refrigerator, int parkingCount, int bathroomCount, int fireAlarm,
            int heatingSystem, int elevator, int pet) {

        this.houseId = houseId;
        this.airConditioner = airConditioner;
        this.refrigerator = refrigerator;
        this.parkingCount = parkingCount;
        this.bathroomCount = bathroomCount;
        this.fireAlarm = fireAlarm;
        this.heatingSystem = heatingSystem;
        this.elevator = elevator;
        this.pet = pet;
    }
}
