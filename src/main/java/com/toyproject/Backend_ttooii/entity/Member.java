package com.toyproject.Backend_ttooii.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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
    @Column(name = "password", length = 20)
    @NotNull
    private String password;

    @Column(name = "email", length = 50, unique = true)
    @NotNull
    private String email;

    @Column(name = "phone", length = 20)
    @NotNull
    private String phone;

    @Column(name = "address", length = 50)
    @NotNull
    private String address;

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

    /*
    @OneToMany(mappedBy = "member")
    private List<House> houses = new ArrayList<>();
    */

    @Builder
    public Member(
            String userId,String email, String username, String phone, String password, String address, String deletion,
            ProviderType providerType, RoleType roleType){

        this.userId = userId;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.providerType = providerType;
        this.roleType = roleType;
        this.address = address;
        this.deletion = deletion;
    }
}
