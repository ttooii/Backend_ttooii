package com.toyproject.Backend_ttooii.dto;

import com.toyproject.Backend_ttooii.entity.House;
import com.toyproject.Backend_ttooii.entity.Wishlist;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WishListDto {
    private House house;
    private String userId;
    private Long wishlistId;

    @Builder
    public WishListDto(House house, String userId, Long wishlistId) {
        this.house = house;
        this.userId = userId;
        this.wishlistId=wishlistId;
    }

    public Wishlist toEntity(){
        return Wishlist.builder()
                .house(house)
                .userId(userId)
                .wishlistId(wishlistId)
                .build();
    }


}
