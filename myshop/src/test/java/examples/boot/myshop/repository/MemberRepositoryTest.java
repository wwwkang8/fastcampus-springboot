package examples.boot.myshop.repository;

import examples.boot.myshop.entity.Member;
import examples.boot.myshop.entity.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Set;

//Runwith는 Junit이 제공하는 확장점
// 즉 Spring이 Junit을 사용할 수 있게 환경 제공
@RunWith(SpringRunner.class)
//@SpringBootTest 이 어노테이션은 스프링이 관리하는 모든 빈들을 띄워서 테스트하는 것이다.
@DataJpaTest //memberRepository만 주입하여 테스트 하는 시간을 줄인다. 슬라이스 테스트.
@Transactional
public class MemberRepositoryTest {

    // 테스트할 객체를 주입 받아야 한다.
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void test(){
        //아무런 일도 안하는 메소드는 스프링 설정이 올바른지만 검사한다.
    }

    @Test
    public void getMember1() throws Exception{
        Member member = memberRepository.findMemberByEmail("wwwkang8@gmail.com");
        Assert.assertNotNull(member); //이것의 활용에 대해 더 공부하기
        Assert.assertEquals("kim",member.getName());

        System.out.println("------------------");
        Set<Role> roles=member.getRoles();
        System.out.println("------------------");

        for(Role role : roles){
            System.out.println(role.getName());
        }
    }

    @Test
    public void getMember2() throws Exception{
        Member member=memberRepository.getMemberAndRoles("wwwkang8@gmail.com");

    }



}
