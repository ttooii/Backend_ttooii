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

    @Builder
    public WishListDto(House house, String user_id) {
        this.house = house;
        this.user_id = user_id;
    }

    public Wishlist toEntity(){
        return Wishlist.builder()
                .house(house)
                .user_id(user_id)
                .build();
    }


}
