package com.toyproject.realty.service;
import java.util.Optional;

import com.toyproject.realty.dto.MemberDto;
import com.toyproject.realty.entity.Member;
import com.toyproject.realty.entity.ProviderType;
import com.toyproject.realty.entity.RoleType;
import com.toyproject.realty.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional(readOnly = true) // 구동 실패 시 Rollback 할 수 있도록 하는 안전장치
@AllArgsConstructor
public class MemberService implements UserDetailsService {
    private MemberRepository memberRepository;

    @Transactional
    public String joinUser(MemberDto memberDto) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        memberDto.setProviderType(ProviderType.LOCAL);
        memberDto.setRoleType(RoleType.USER);
        memberDto.setDeletion("N");
        return memberRepository.save(memberDto.toEntity()).getUserId();
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<Member> memberWrapper = memberRepository.findByuserId(userId);
        Member member = memberWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        return new User(member.getUserId(), member.getPassword(), authorities);
    }
    public boolean checkUserIdDuplicate(String userId){
        return memberRepository.existsByUserId(userId);
    }
    public boolean checkEmailDuplicate(String email){
        return memberRepository.existsByEmail(email);
    }
}
