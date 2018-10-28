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
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest //MemberRepository만 주입하여 테스트 하는 시간을 줄인다.
@Transactional
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void test(){
        //아무일도 하지 않는 메서드이지만 스프링 설정이 올바른지만 검사한다.
    }

    @Test
    public void getMember1() throws Exception{
        Member member=memberRepository.findMemberByEmail("wwwkang8@gmail.com");
        Assert.assertNotNull(member);//이것의 활용에 대해 더 공부하기.
        Assert.assertEquals("kim", member.getName());

        System.out.println("----------------------");
        Set<Role> roles=member.getRoles();
        System.out.println("----------------------");

        for(Role role : roles){
            System.out.println(role.getName());
        }


    }

    @Test
    public void getMember2(){
        Member member=memberRepository.getMemberAndRoles("wwwkang8@gmail.com");
    }



}
