package examples.boot.myshop.repository;

import examples.boot.myshop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //메서드 이름으로 구하는 것을 Query Method 라고 한다
    public Member findMemberByEmail(String email);

    @Query("select m from Member m join fetch m.roles where m.email = :email")
    public Member getMemberAndRoles(@Param("email")String email);


}
