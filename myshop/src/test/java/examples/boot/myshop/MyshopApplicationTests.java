package examples.boot.myshop;

import examples.boot.myshop.entity.Board;
import examples.boot.myshop.entity.Category;
import examples.boot.myshop.repository.BoardRepository;
import examples.boot.myshop.repository.CategoryRespository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional //test에서 @Transactional을 사용하면 자동 롤백 된다.
public class MyshopApplicationTests {

    @Autowired // 테스트할 클래스를 오토와이어로 주입 받는다
            CategoryRespository categoryRespository; // test할 대상을 주입 받는다.

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
        Category category = categoryRespository.getOne(1L);
        System.out.println(category.getId());
        System.out.println(category.getName());
        Category category2 = categoryRespository.getOne(1L);
        if (category == category2) {
            // getOne()을 2번 사용했지만 실제로 쿼리는 1번만 된것을 확인할 수 있다.
            // 그 이유는 같은 트랜잭션 내에서는 1차캐시를 이용하기 때문이다.
            System.out.println("category == category2");
        }
    }

    @Test
    public void test2() {
        System.out.println("-------------------------------------");
        System.out.println(categoryRespository.getClass().getName()); // 프록시 객체가 출력된다.
        Category category = categoryRespository.getOne(1L);
        List<Board> boards = category.getBoards(); // 이 때는 쿼리가 실행되지 않았다.
        System.out.println("-------------------------------------");
        System.out.println(boards.getClass().getName());
        System.out.println("-------------------------------------");

        for (Board board : boards) {//실제로 이 때 쿼리가 실행되었다.
            System.out.println(board.getTitle());
        }
        System.out.println("-------------------------------------");
    }

    @Test
    public void test3() {
        List<Board> list = boardRepository.findAllByName("kim");
        for (Board board : list) {
            System.out.println(board.getTitle());
        }
    }

    @Test
    public void test4() {
        //List<Board> list=boardRepository.findAll();
        List<Board> list = boardRepository.getBoards(); //쿼리가 1번만 실행된다. 조인한 결과를 가져올 수 있다.
        for (Board board : list) {
            System.out.println(board.getTitle());
            System.out.println(board.getCategory().getName());
        }
    }

}
