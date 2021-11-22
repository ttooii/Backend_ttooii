package com.toyproject.Backend_ttooii.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"houseList"})
    @ManyToOne
    private Member member;

    @Builder
    public Wishlist(House house, Member member) {
        this.house = house;
        this.member = member;
    }
}
