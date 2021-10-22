package com.toyproject.realty.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@Table(name = "MEMBER")
public class Member extends BaseTimeEntity{

    @Id
    @Column(name = "user_id", length = 20, unique = true)
    @NotNull
    private String userId;

    @Column(name = "username", length = 20)
    @NotNull
    private String username;

    @JsonIgnore
    @Column(name = "password", length = 100)
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
    @ColumnDefault("LOCAL")
    private ProviderType providerType;

    @Column(name = "ROLE_TYPE", length = 20)
    @Enumerated(EnumType.STRING)
    @ColumnDefault("ROLE_USER")
    private RoleType roleType;

//    @Column(name = "CREATED_AT")
//    @NotNull
//    private LocalDateTime createdAt;
//
//    @Column(name = "MODIFIED_AT")
//    @NotNull
//    private LocalDateTime modifiedAt;

    @Column(name = "deletion")
    @ColumnDefault("N")
    private String deletion;


    @Column(name="address")
    private String address;
    @Builder
    public Member(String userId,String email, String username, String phone, String password,ProviderType providerType, RoleType roleType,String deletion,String address){
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.roleType=roleType;
        this.providerType=providerType;
        this.deletion=deletion;
        this.address=address;
    }}
