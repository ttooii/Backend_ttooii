package com.toyproject.realty.dto;

import com.toyproject.realty.entity.Member;
import lombok.*;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private String userId;
    private String email;
    private String password;
    private String username;
    private String phone;
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
    public MemberDto(String userId, String email, String password) {
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public void setPassword() {
    }
}
