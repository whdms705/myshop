package com.example.myshop.entitiy;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="member")
@Setter
@Getter
@Data
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String password;
    LocalDateTime regdate;

    @ManyToMany
    @JoinTable(name="member_member_role",
                joinColumns = @JoinColumn(name ="member_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name ="member_role_id",referencedColumnName = "id")
    )
    Set<Role> roles;

    public Member(){
        this.regdate = LocalDateTime.now();
    }

    //helper
    //public void addRole()

}

/*

 */
