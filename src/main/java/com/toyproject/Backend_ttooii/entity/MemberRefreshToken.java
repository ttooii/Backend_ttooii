package com.toyproject.Backend_ttooii.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_REFRESH_TOKEN")
public class MemberRefreshToken {
    @JsonIgnore
    @Id
    @Column(name = "refresh_token_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refreshTokenSeq;

    @Column(name = "user_id", length = 64, unique = true)
    @NotNull
    private String userId;

    @Column(name = "refresh_token", length = 256)
    @NotNull
    private String refreshToken;

    public MemberRefreshToken(
            @NotNull String userId,
            @NotNull String refreshToken
    ) {
        this.userId = userId;
        this.refreshToken = refreshToken;
    }
}