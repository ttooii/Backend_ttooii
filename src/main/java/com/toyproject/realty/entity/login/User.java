package com.toyproject.realty.entity.login;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER")
public class User {

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

    @Column(name = "CREATED_AT")
    @NotNull
    private LocalDateTime createdAt;

    @Column(name = "MODIFIED_AT")
    @NotNull
    private LocalDateTime modifiedAt;

    @Column(name = "deletion")
    @NotNull
    private String deletion;

    public User(
            @NotNull String userId,
            @NotNull String username,
            @NotNull String email,
            @NotNull ProviderType providerType,
            @NotNull RoleType roleType,
            @NotNull LocalDateTime createdAt,
            @NotNull LocalDateTime modifiedAt,
            @NotNull String deletion
    ) {
        this.userId = userId;
        this.username = username;
        this.password = "NO_PASS";
        this.email = email != null ? email : "NO_EMAIL";
        this.providerType = providerType;
        this.roleType = roleType;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deletion = deletion;
    }
}
