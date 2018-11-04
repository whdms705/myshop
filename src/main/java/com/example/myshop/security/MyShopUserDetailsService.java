package com.example.myshop.security;

import com.example.myshop.entitiy.Member;
import com.example.myshop.entitiy.Role;
import com.example.myshop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class MyShopUserDetailsService implements UserDetailsService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.getMemberAndRoles(email);
        if(member==null){
            throw new UsernameNotFoundException(email+" is not found");
        }
        String password = member.getPassword();
        //String password ="{bcrypt}$2a$10$.bavDyCKkXJahmBUf/pEIOL85sH/tY.j50lRsQVHExjuqekJJ7OmS";
        Collection<GrantedAuthority> authorities = new HashSet<>();
        Set<Role> roles = member.getRoles();
        for(Role role:roles){
            authorities.add(new SimpleGrantedAuthority("ROlE_"+role.getName()));
        }
        LoginUser loginUser = new LoginUser(email,password,authorities);
        loginUser.setId(member.getId());
        loginUser.setName(member.getName());

        return loginUser;
    }

}
