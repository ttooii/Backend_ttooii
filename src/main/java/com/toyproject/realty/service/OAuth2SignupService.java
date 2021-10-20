package com.toyproject.realty.service;



import com.toyproject.realty.dto.SocialMemberDto;
import com.toyproject.realty.entity.ProviderType;
import com.toyproject.realty.entity.RoleType;
import com.toyproject.realty.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true) // 구동 실패 시 Rollback 할 수 있도록 하는 안전장치
@AllArgsConstructor
public class OAuth2SignupService {

    CustomOAuth2UserService customOAuth2UserService;

    private MemberRepository memberRepository;

    public boolean findDB(Authentication authentication){
        String information= authentication.getPrincipal().toString();
        String email;
        String target = "email=";
        boolean exist=false;
        int target_num = information.lastIndexOf(target);
        email = information.substring(information.lastIndexOf(target)+6,(information.substring(target_num).indexOf(",")+target_num));
       if(memberRepository.findByEmail(email)!=null){
            exist=true;
       }
       return exist;
    }

    @Transactional
    public String socialJoinUser(SocialMemberDto socialmemberDto, Authentication authentication) {

        String information= authentication.getPrincipal().toString();
        String email;
        String username;
        String target = "email=";
        String uniqueID = UUID.randomUUID().toString().substring(0,10);
        String uniquePassword=UUID.randomUUID().toString();
        int target_num = information.lastIndexOf(target);
        System.out.println(information);
        email = information.substring(information.lastIndexOf(target)+6);
        email= email.split(",|}")[0];

        target="name=";
        target_num=information.indexOf(target);
        username=information.substring(information.indexOf(target)+5);
        username=username.split(",|}")[0];

        socialmemberDto.setPassword(uniquePassword);
        socialmemberDto.setEmail(email);
        socialmemberDto.setUsername(username);
        socialmemberDto.setUserId(uniqueID);
        socialmemberDto.setDeletion("N");
        socialmemberDto.setRoleType(RoleType.USER);
        if(customOAuth2UserService.getProviderType().equals("naver")){
            socialmemberDto.setProviderType(ProviderType.NAVER);
        }
        else{
            socialmemberDto.setProviderType(ProviderType.KAKAO);
        }
        return memberRepository.save(socialmemberDto.toEntity()).getPhone();
    }
}
