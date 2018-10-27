package examples.boot.myshop.security;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME) //어플리케이션 실행시
@Documented
public @interface AuthUser {



}
