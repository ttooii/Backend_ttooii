package com.toyproject.Backend_ttooii.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "LIKE_LOCATION")
public class LikeLocation {

    @Id
    @Column(name = "likelocation_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long likelocationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private Member userId;

    @Column(name = "district")
    private String district;

    @Builder
    public LikeLocation(Long likelocationId, Member userId, String district) {
        this.likelocationId = likelocationId;
        this.userId = userId;
        this.district = district;
    }
}
