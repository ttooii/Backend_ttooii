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
    private String username;
    private String email;
    private String phone;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Member toEntity(){
        return Member.builder()
                .userId(userId)
                .username(username)
                .phone(phone)
                .email(email)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(String userId,String email, String username, String phone, String password){
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.password = password;
    }

    public void setPassword() {
    }
}
