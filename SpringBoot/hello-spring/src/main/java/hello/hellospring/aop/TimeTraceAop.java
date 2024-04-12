package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// @Component : 빈 등록 -> @보다 config파일에 bean 등록을 더 선호
// @Aspect : aop로 인식
// @Around : 공통 관심사항을 어디에 사용할지 타겟팅
@Component
@Aspect
public class TimeTraceAop {
  @Around("execution(* hello.hellospring..*(..))")
  public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis(); // 시작 ms 가져옴
    System.out.println("START: " + joinPoint.toString());
    try {
      return joinPoint.proceed(); // 다음 메소드 진행
    } finally {
      long finish = System.currentTimeMillis();
      long timeMs = finish - start;
      System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
    }
  }
}
