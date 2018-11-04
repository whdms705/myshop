package com.example.myshop.repository;

import com.example.myshop.entitiy.Member;
import com.example.myshop.entitiy.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Set;

// @RunWith(SpringRunner.class) -> Junit이 제공하는 확장점  @SpringBootTest-> 모든 빈을 테이터 올려줘서 테스트
// @DataJpaTest -> SpringBoot에서 JPA만 테스트할 수 있도록 제공하는 어노테이션
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public  class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void getMember1() throws Exception{
        Member member = memberRepository.findMemberByEmail("urstory@gmail.com");
        Assert.assertNotNull(member); // null이 아니면 성공.
        Assert.assertEquals("kim", member.getName());
        System.out.println("---------------------");
        Set<Role> roles = member.getRoles();
        System.out.println("---------------------");
        for(Role role:roles){
            System.out.println(role.getName());
        }
    }
    @Test
    public void getMember2() throws Exception{
        Member member = memberRepository.getMemberAndRoles("urstory@gmail.com");
        Assert.assertNotNull(member); // null이 아니면 성공.
        Assert.assertEquals("kim", member.getName());
        System.out.println("---------------------");
        Set<Role> roles = member.getRoles();
        System.out.println("---------------------");
        for(Role role:roles){
            System.out.println(role.getName());
        }
    }


}
