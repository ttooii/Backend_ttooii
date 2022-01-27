package com.toyproject.Backend_ttooii.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishlistId;


    @ManyToOne(targetEntity = House.class,fetch = FetchType.LAZY)
    @JoinColumn(name="house_id")
    private House house;

    @Column(name = "user_id")
    private String userId;

    @Builder
    public Wishlist(House house, String userId,Long wishlistId) {
        this.house = house;
        this.userId = userId;
        this.wishlistId=wishlistId;
    }
}
