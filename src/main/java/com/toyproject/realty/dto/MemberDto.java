package com.toyproject.realty.dto;

import com.toyproject.realty.entity.Member;
import com.toyproject.realty.entity.ProviderType;
import com.toyproject.realty.entity.RoleType;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    @NotBlank(message = "ID는 필수 입력 값입니다.")
    @Size(max = 20, message = "20자 이하로 입력해주세요.")
    private String userId;

    @NotBlank(message = "Name은 필수 입력 값입니다. ")
    @Size(max = 50, message = "50자 이하로 입력해주세요.")
    private String username;

    @NotBlank(message = "Email은 필수 입력 값입니다.")
    @Size(max = 50, message = "50자 이하로 입력해주세요.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

    @NotBlank(message = "Phone는 필수 입력 값입니다. 예시) 010-xxxx-xxxx.")
    private String phone;

    @NotBlank(message = "Password는 필수 입력 값입니다. 20자 이하로 입력해주세요.")
    @Size(max = 20, message = "20자 이하로 입력해주세요.")
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
                .build();
    }

}