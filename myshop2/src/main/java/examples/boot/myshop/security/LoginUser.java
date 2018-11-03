package examples.boot.myshop.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

//Spring Security가 제공하는 User에 필드를 추가한다.
public class LoginUser extends User {

    private String name;
    private Long id;

    //User가 기본 생성자가 없어서 에러가 발생한다. 그래서 부모의 생성자를 호출
    public LoginUser(String email, String password, Collection<? extends GrantedAuthority> authorities){
        super(email, password, true,true,true,true,authorities);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
