package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행한다
@Transactional// 테스트 시작 전 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백 DB에 영향을 주지 않는다 -> 다음 테스트에 영향을 주지 않는다
class MemberServiceIntegrationTest {

  // 테스트코드 한정 : 필드기반의 의존성 주입 유용
  @Autowired MemberService memberService;
  @Autowired MemberRepository memberRepository;

  @Test
  void 회원가입() throws Exception {

    //Given
    Member member = new Member();
    member.setName("hello");

    //When
    Long saveId = memberService.join(member);

    //Then
    Member findMember = memberService.findOne(saveId).get();
    assertEquals(member.getName(), findMember.getName());
  }

  @Test
  void 중복_회원_예외() throws Exception {

    //Given
    Member member1 = new Member();
    member1.setName("spring");

    Member member2 = new Member();
    member2.setName("spring");

    //When
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));//예외가 발생해야 한다.

    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
  }
}