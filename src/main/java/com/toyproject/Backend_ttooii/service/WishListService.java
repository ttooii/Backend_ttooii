package com.toyproject.Backend_ttooii.service;

import com.toyproject.Backend_ttooii.dto.WishListDto;
import com.toyproject.Backend_ttooii.entity.Wishlist;
import com.toyproject.Backend_ttooii.repository.WishListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class WishListService {
    private WishListRepository wishListRepository;

    @Transactional
    public List<WishListDto> getWishList() {
       List<Wishlist> wishlists=wishListRepository.findAll();
       List<WishListDto> wishListDtoList=new ArrayList<>();
       for(Wishlist wishlist: wishlists){
           WishListDto wishListDto=WishListDto.builder()
                   .house(wishlist.getHouse())
                   .build();
           wishListDtoList.add(wishListDto);
       }
       return  wishListDtoList;
    }

    @Transactional
    public int savePost(WishListDto wishListDto){
        return wishListRepository.save(wishListDto.toEntity()).getWishlistId();
    }

    @Transactional
    public void deleteWishList(Long house_id) {
        wishListRepository.deleteById(house_id);
    }
}
