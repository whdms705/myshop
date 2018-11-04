package com.example.myshop.repository;

import com.example.myshop.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member,Long> {
    public Member findMemberByEmail(String email);

    @Query("select m from Member m join fetch  m.roles where m.email = :email")
    public Member getMemberAndRoles(@Param("email") String email);
}
