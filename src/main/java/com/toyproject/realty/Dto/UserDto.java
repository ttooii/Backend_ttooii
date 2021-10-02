package com.toyproject.realty.Dto;

import com.toyproject.realty.entity.login.Member;
import lombok.*;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
    private String userId;
    private String email;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Member toEntity(){
        return Member.builder()
                .userId(userId)
                .email(email)
                .password(password)
                .build();
    }

    @Builder
    public UserDto(String userId, String email, String password) {
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public void setPassword() {
    }
}
