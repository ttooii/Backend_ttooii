package com.toyproject.Backend_ttooii.service;

import com.toyproject.Backend_ttooii.dto.LikeLocationDto;
import com.toyproject.Backend_ttooii.dto.NoticeDto;
import com.toyproject.Backend_ttooii.entity.LikeLocation;
import com.toyproject.Backend_ttooii.entity.Notice;
import com.toyproject.Backend_ttooii.repository.LikeLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class LikeLocationService {

    @Autowired
    LikeLocationRepository likeLocationRepository;

    @Transactional
    public List<LikeLocationDto> getLikeLocList(String userId) {
        List<LikeLocation> likeLocations = likeLocationRepository.findByUserId(userId);
        List<LikeLocationDto> likeLocationDtoList = new ArrayList<>();
        for (LikeLocation loc : likeLocations) {
            LikeLocationDto likeLocationDto = LikeLocationDto.builder()
                    .likelocationId(loc.getLikelocationId())
                    .userId(loc.getUserId())
                    .district(loc.getDistrict())
                    .build();

            likeLocationDtoList.add(likeLocationDto);
        }
        return likeLocationDtoList;
    }
    @Transactional
    public Long saveLikeLocation(LikeLocationDto likeLocationDto) {
        LikeLocation likeLocation = likeLocationDto.toEntity();

        return likeLocation.getLikelocationId();

    }
}
