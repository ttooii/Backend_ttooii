package com.toyproject.Backend_ttooii.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "HOUSE")
public class House {

    @Id
    @Column(name = "house_id", length = 5, unique = true)
    @GeneratedValue(generator = "USER_GENERATOR")
    @GenericGenerator(name = "USER_GENERATOR", strategy = "uuid")
    @NotNull
    private String houseId;

    @Column(name = "transaction_type", length = 20)
    private int transactionType;

    @Column(name = "service_type")
    private int serviceType;

    @Column(name = "floor")
    private int floor;

    @Column(name = "total_floor")
    private int totalFloor;

    @Column(name = "room_count")
    private int roomCount;

    @Column(name = "administration_cost")
    private int administrationCost;

    @Column(name = "bathroom_count")
    private int bathroomCount;

    @Column(name = "direction")
    private String direction;

    @Column(name = "moves_in_dates")
    private String movesInDates;

    @Column(name = "hit")
    private int hit;

    @Column(name = "wish_count")
    private int wishCount;

    @Column(name = "deletion")
    private int deletion;

    @Column(name = "title",  length = 50)
    private String title;

    @Column(name = "content",  length = 1000)
    private String content;

    @Column(name = "land_area")
    private float landArea;

    @Column(name = "location")
    private String location;

    @Column(name = "monthly_expenses")
    private int monthlyExpenses;

    @Column(name="registrant")
    private String registrant;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;
    */

    /*
    @JsonIgnoreProperties({"houseId"})
    @OneToMany(mappedBy = "houseId")
    private List<Inclusive> inclusive = new ArrayList<Inclusive>();
    */

    @Builder
    public House(
            String registrant, String houseId, String direction, String movesInDates, String title, String content, String location,
            int transactionType, int floor, int totalFloor, int roomCount, int administrationCost, int bathroomCount, int hit, int wishCount, float landArea, int serviceType, int monthlyExpenses,
            Date completionApproval, Member member, Inclusive inclusive) {

        this.registrant = registrant;
        this.houseId = houseId;
        this.transactionType = transactionType;
        this.floor = floor;
        this.totalFloor = totalFloor;
        this.roomCount = roomCount;
        this.administrationCost = administrationCost;
        this.bathroomCount = bathroomCount;
        this.direction = direction;
        this.movesInDates = movesInDates;
        this.hit = hit;
        this.wishCount = wishCount;
        this.title = title;
        this.content = content;
        this.landArea = landArea;
        this.serviceType = serviceType;
        this.location = location;
        this.monthlyExpenses = monthlyExpenses;
        // this.member = member;
    }
}
