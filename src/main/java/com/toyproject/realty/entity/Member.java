package com.toyproject.realty.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name = "user_id", length = 20, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private String userId;

    @Column(name = "nickname", length = 20)
    @NotNull
    private String username;

    @JsonIgnore
    @Column(name = "password", length = 20)
    @NotNull
    private String password;

    @Column(name = "email", length = 50, unique = true)
    @NotNull
    private String email;

    @Column(name = "phone", length = 20)
    @NotNull
    private String phone;

    @Column(name = "PROVIDER_TYPE", length = 20)
    @Enumerated(EnumType.STRING)
    @NotNull
    private ProviderType providerType;

    @Column(name = "ROLE_TYPE", length = 20)
    @Enumerated(EnumType.STRING)
    @NotNull
    private RoleType roleType;

//    @Column(name = "CREATED_AT")
//    @NotNull
//    private LocalDateTime createdAt;
//
//    @Column(name = "MODIFIED_AT")
//    @NotNull
//    private LocalDateTime modifiedAt;

    @Column(name = "deletion")
    @NotNull
    private String deletion;

    @Builder
    public Member(String userId,String email, String username, String phone, String password){
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.password = password;
    }
}
