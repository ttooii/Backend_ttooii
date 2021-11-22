package com.toyproject.Backend_ttooii.dto;

import com.toyproject.Backend_ttooii.entity.Member;
import com.toyproject.Backend_ttooii.entity.ProviderType;
import com.toyproject.Backend_ttooii.entity.RoleType;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class SocialMemberDto {
    @NotBlank(message = "Phone는 필수 입력 값입니다. 예시) 010-xxxx-xxxx.")
    private String phone;

    @NotBlank(message = "Address는 필수 입력 값입니다.")
    private String address;

    private String userId;
    private String username;
    private String email;
    private String password;
    private ProviderType providerType;
    private RoleType roleType;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private  String deletion;
    public Member toEntity() {
        return Member.builder()
                .userId(userId)
                .username(username)
                .phone(phone)
                .email(email)
                .password(password)
                .providerType(providerType)
                .roleType(roleType)
                .deletion(deletion)
                .address(address)
                .build();
    }

}