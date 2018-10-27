package examples.boot.myshop.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//Runwith는 Junit이 제공하는 확장점
// 즉 Spring이 Junit을 사용할 수 있게 환경 제공
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    // 테스트할 객체를 주입 받아야 한다.
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void test(){
        //아무런 일도 안하는 메소드는 스프링 설정이 올바른지
    }



}
