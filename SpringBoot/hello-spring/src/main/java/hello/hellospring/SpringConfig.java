package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  // 스프링 컨테이너에서 MemberRepository를 찾음 => SpringDataJpaMemberRepository interface
  // 주입 받으면 Spring Data JPA가 구현체를 만들어 놓은 게 bean으로 등록된다.
  @Autowired // 단일 생성자라서 생략 가능
  private final MemberRepository memberRepository;

  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  // MemberService에도 의존관계 설정
  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository);
  }

/*
  @Bean
  public TimeTraceAop TimeTraceAop() {
    return new TimeTraceAop();
  }
*/

}
