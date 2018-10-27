package examples.boot.myshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity //엔티티이기 때문에 어노테이션 붙인다
@Table(name = "category") //엔티티와 관련을 맺고 있는 테이블이 category 테이블이라고 명시
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Board> boards;

}
