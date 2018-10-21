package examples.boot.myshop.repository;

import examples.boot.myshop.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    public List<Board> findAllByName(String name);

    //SQL문이 아니고 객체지향 언어인 JPQL이다.
    @Query("select b from Board b join fetch b.category")
    public List<Board> getBoards();
    /*from 뒤에 나온 것은 테이블이 아니고 엔티티이름이다.
     * 모든 board 엔티티를 구해라
     * */

    /*여기 위에 아예 SQL 문을 써도 되지만 그렇게 되면 특정 DBMS에 종속적으로 되기 때문에 JPA를 사용할 땐 추천하지 않는다*/
}
