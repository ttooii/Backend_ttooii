package com.toyproject.Backend_ttooii.dto;

import com.toyproject.Backend_ttooii.entity.LikeLocation;
import com.toyproject.Backend_ttooii.entity.Member;
import com.toyproject.Backend_ttooii.entity.Notice;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class LikeLocationDto {

    private Long likelocationId;
    private String district;
    private Member userId;

    public LikeLocation toEntity(){
        LikeLocation likeLocation = LikeLocation.builder()
                .likelocationId(likelocationId)
                .district(district)
                .userId(userId)
                .build();

        return likeLocation;
    }

    @Builder
    public LikeLocationDto(Long likelocationId, String district, Member userId) {

        this.likelocationId = likelocationId;
        this.district = district;
        this.userId = userId;
    }
}
