package com.toyproject.Backend_ttooii.service;

import com.toyproject.Backend_ttooii.dto.HouseListDto;
import com.toyproject.Backend_ttooii.dto.WishListDto;
import com.toyproject.Backend_ttooii.entity.House;
import com.toyproject.Backend_ttooii.entity.Wishlist;
import com.toyproject.Backend_ttooii.repository.WishListRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class WishListService {
    private WishListRepository wishListRepository;

    @Transactional
    public void delete(Long id) {
        wishListRepository.deleteById(id);
    }

    @Transactional
    public void saveWishList(HouseListDto houseDto, Authentication authentication){

        House house=House.builder()
                .houseId(houseDto.getHouseId())
                .transactionType(houseDto.getTransactionType())
                .floor(houseDto.getFloor())
                .totalFloor(houseDto.getTotalFloor())
                .roomCount(houseDto.getRoomCount())
                .administrationCost(houseDto.getAdministrationCost())
                .direction(houseDto.getDirection())
                .title(houseDto.getTitle())
                .content(houseDto.getContent())
                .landArea(houseDto.getLandArea())
                .location(houseDto.getLocation())
                .serviceType(houseDto.getServiceType())
                .monthlyExpenses(houseDto.getMonthlyExpenses())
                .build();

        WishListDto wishlistDto=WishListDto.builder()
                .house(house)
                .build();
        if(authentication.getName().length()>20){
            wishlistDto.setUserId(authentication.getName().substring(0,19));
        }
        else{
            wishlistDto.setUserId(authentication.getName());
        }
        wishListRepository.save(wishlistDto.toEntity());
    }

    @Transactional
    public Page<Wishlist> getWishList(int page, Authentication authentication){
        String userId;
        if(authentication.getName().length()>20){
           userId=authentication.getName().substring(0,19);
        }
        else{
            userId=authentication.getName();
        }

        return wishListRepository.findByUserId(authentication.getName(),PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "wishlistId")));
    }

}
