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

    //@ManyToMany(cascade = {CascadeType.ALL}) //우리가 사용하는 Role정보는 이미 DB에 저장되어 있다.
    @ManyToMany
    @JoinTable(name="member_member_role",
                joinColumns = @JoinColumn(name="member_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name="member_role_id", referencedColumnName = "id"))
    Set<Role> roles; // Member는 여러개의 Role을 가질 수 있기 때문이다.


    public Member(){ // 생성자에는 현재 시간에 대한 정보를 받는다.
        this.regDate=LocalDateTime.now();
    }

    //helper method : Role객체를 보다 편하게 추가할 수 있도록 해주는 함수.
    public void addRole(Role role){
        if(roles == null){
            roles=new HashSet<>();
        }
        roles.add(role);
    }
}


/*

   Set<Role> roles=new HashSet<>();
   roles.add(role);
* Memebr member = new Memeber();
* member.setRoles(**);
*
* Member member= ''''
* Set<Role> roles = member.getRoles();
* roles.add(추가하고자 하는 role);
* member.setRoles(roles);
*
* */











