package examples.boot.myshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="member")
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String password;
    LocalDateTime regDate;

    @ManyToMany
    @JoinTable(name="member_member_role",
               joinColumns = @JoinColumn(name="member_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name="member_role_id", referencedColumnName = "id"))
    Set<Role> roles;

    public Member(){
        this.regDate=LocalDateTime.now();
    }

    //helper method : Role객체를 보다 편하게 추가할 수 있도록 해주는 함수
    public void addRole(Role role){
        if(roles==null){
            roles=new HashSet<>();
        }
        roles.add(role);
    }

}


