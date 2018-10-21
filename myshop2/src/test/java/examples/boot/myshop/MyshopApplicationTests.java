package examples.boot.myshop;

import examples.boot.myshop.entity.Board;
import examples.boot.myshop.entity.Category;
import examples.boot.myshop.repository.BoardRepository;
import examples.boot.myshop.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional // test에서 @Transactional을 사용하면 자동 롤백된다.
public class MyshopApplicationTests {

	@Autowired //테스트할 클래스를 오토와이어로 주입
	CategoryRepository categoryRespository;

	@Autowired
	BoardRepository boardRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1(){
		Category category=categoryRespository.getOne(1L);
		System.out.println(category.getId());
		System.out.println(category.getName());
		Category category2 = categoryRespository.getOne(1L);
		if(category==category2){
			System.out.println("category==category2");
		}
	}

	@Test
	public void test2(){
		System.out.println("------------------------------");
		System.out.println(categoryRespository.getClass().getName()); //프록시 객체 출력
		Category category = categoryRespository.getOne(1L); //Category 쿼리문 실행
		List<Board> boards=category.getBoards(); //Board 쿼리가 실행되지 않았다.
		System.out.println("------------------------------");
		System.out.println(boards.getClass().getName()); //PersistenceBag
		System.out.println("------------------------------");

		for(Board board : boards){ //실제로 Board 쿼리가 실행된 시점
			System.out.println(board.getTitle());
		}
		System.out.println("------------------------------");

	}

	@Test
	public void test3(){
		List<Board> list=boardRepository.findAllByName("kim");
		//System.out.println(list);
		for(Board board : list){
			System.out.println(board.getTitle());
		}
	}

	@Test
	public void test4(){
		List<Board> list1=boardRepository.findAll(); //이것은 1+N문제를 발생시킨다.
		List<Board> list2=boardRepository.getBoards();//쿼리가 1번만 실행된다. 조인한 결과를 가져올 수 있다.

		for(Board board : list2){
			System.out.println(board.getTitle());
			System.out.println(board.getCategory().getName());
		}


	}


}
