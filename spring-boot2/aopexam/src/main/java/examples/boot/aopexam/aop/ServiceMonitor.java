package examples.boot.aopexam.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // Aspect = Advice + JoinPoint + PointCut 이 3가지가 합쳐진 것.
@Component // @Aspect를 Bean으로 등록하려면 @Component가 붙어야 한다.
public class ServiceMonitor {
    // 메소드가 실행될 때 메소드 이름을 출력.

    //메서드에 삽입할 위치 : JoinPoint
    //메서드가 시작할 때
    //메서드가 종료될 때, 어떤 값을 리턴할 때
    //Exception이 발생할 때
    // 메서드의 시작과 종료시에
    //이런 시점에 자동으로 메서드를 호출하고 싶다.

    // 삽입할 기능(ex : 로그를 남긴다.) : Advice.
    // Advice가 JoinPoint와 연관을 맺게 할 것이냐? PointCut
    // Aspect는 3개를 모두 합친것

    // examples로 시작하는 패키지를 가지고 있고, 클래스명이 Service로 끝난다면
    // 해당 클래스의 메소드의 시작위치에서 해당 코드를 실행한다.
    //execution(* examples..*Service.*(..)) : execution 실행될 떄, *
    // 처음 * : 리턴 type이 무엇이든 상관 없다.
    // examples : examples로 시작하는 어떤 패키지든 상관 없다.
    // *Service : 클래스 이름은 Service로 끝나야 한다.
    // *(..) : 파라미터는 무엇이든 상관 없고. 모든 메서드
    @Before("execution(* examples..*Service.*(..))")
    public void beforeExec(JoinPoint joinPoint) {
        System.out.println("------------------------------------------------");
        System.out.println("name : " + joinPoint.getSignature().getName());
        System.out.println("------------------------------------------------");
    }

    @AfterReturning("execution(* examples..*Service.*(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        System.out.println("name : " + joinPoint.getSignature().getName());
        System.out.println("Completed: " + joinPoint);
    }

    @AfterThrowing(value = "execution(* examples..*Service.*(..))", throwing = "ex")
    public void afterException(JoinPoint joinPoint, Exception ex) {
        System.out.println("**********************************");
        System.out.println("exception :" + joinPoint);
        System.out.println(ex.getMessage());
        System.out.println("**********************************");
    }
}
