package examples.boot.myshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Target;

@Entity
@Table(name="member_role") //생성될 테이블의 이름지정
@Getter
@Setter
public class Role { // Role은 엔티티 이름

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    //단방향으로 지정하였기 때문에 Member와의 관계는 따로 명시하지 않는다.
}
