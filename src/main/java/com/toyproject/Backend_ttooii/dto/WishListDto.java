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
    private String user_id;
    private Long wishlistId;

    @Builder
    public WishListDto(House house, String user_id, Long wishlistId) {
        this.house = house;
        this.user_id = user_id;
        this.wishlistId=wishlistId;
    }

    public Wishlist toEntity(){
        return Wishlist.builder()
                .house(house)
                .user_id(user_id)
                .wishlistId(wishlistId)
                .build();
    }


}
