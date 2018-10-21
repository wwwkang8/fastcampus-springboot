package examples.boot.myshop.repository;

import examples.boot.myshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    /*
    * 이렇게만 인터페이스를 선언해도
    * 기본적으로 입력, 수정, 삭제, 조회가 가능하다.
    * 이것은 인터페이스이지만 이것을 구현하는 클래스를 만들지 않아도 된다.
    * Spring Data JPA가 자동으로 이것을 구현하는 클래스를 프록시 객체로 만들어준다.
    * */

}
