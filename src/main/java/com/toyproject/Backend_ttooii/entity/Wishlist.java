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
    private String user_id;

    @Builder
    public Wishlist(House house, String user_id,Long wishlistId) {
        this.house = house;
        this.user_id = user_id;
        this.wishlistId=wishlistId;
    }
}
