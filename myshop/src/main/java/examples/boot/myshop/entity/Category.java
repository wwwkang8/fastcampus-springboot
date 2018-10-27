package examples.boot.myshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //엔티티이기 때문에 어노테이션 붙인다
@Table(name = "category") //엔티티와 관련을 맺고 있는 테이블이 category라는 것을 명시
@Getter
@Setter
public class Category {

    @Id //식별자
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //primary key는 자동 생성되는게 좋다. 수동으로 하게 되면 직접 그 키가 있는지 먼저 파악해야 하기 때문이다.
    private Long id;
    private String name;

    //@OneToMany(mappedBy = "category", fetch = FetchType.EAGER) //Board엔티티의 필드명. Board엔티티에 가보면 category로 변수 선언되어 있다.
    @OneToMany(mappedBy = "category")
    private List<Board> boards;
    /*위의 두개 id, name은 반드시 Getter, setter가 필요해서 롬복으로 설정하였다.*/
    /*FetchType.EAGER는 두 엔티티를 한 몸처럼 사용할 때 붙인다. 그렇지 않으면 보통은 LAZY를 사용한다
     * 기본적으로 LAZY로 두고, JOIN을 쓰고 싶으면 Repository를 사용해라
     * */

    /*spring.jpa.hibernate.ddl-auto= create-drop
    spring.jpa.show-sql=true
    테이블을 자동으로 생성하고 지운다는 옵션
    매번 서버 킬 때 지우고 다시 생성
    */

    //helper 메서드
    /*Board와 Category는 양방향이다.
    * 그래서 boards.add(board)를 하게되면 맞지않는 카테고리가 저장될 수 있다.
    * 그렇기 때문에 board.setCategory(this)를 하여 카테고리를 지정해주어야 한다.*/
    public void addBoard(Board board){
        if(boards == null){
            boards=new ArrayList<>();
        }
        board.setCategory(this);
        boards.add(board);
    }
}
