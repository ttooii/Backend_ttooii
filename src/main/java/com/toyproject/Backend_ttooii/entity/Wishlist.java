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
    private int wishlistId;

    @JoinColumn(name = "house_id")
    @ManyToOne
    private House house;

    @Column(name = "user_id")
    private String user_id;

    @Builder
    public Wishlist(House house, String user_id) {
        this.house = house;
        this.user_id = user_id;
    }
}
