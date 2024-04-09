package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

  MemberService memberService;
  MemoryMemberRepository memberRepository;

  // 각각 테스트 메소드가 실행되기전에 실행되어야 하는 메소드를 명시
  // 데이터 베이스 연결 설정하거나 테스트용 객체를 초기화하는 등의 작업 실행
  @BeforeEach
  public void beforeEach() {
    memberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);
  }

  // 테스트 실행이 되고 끝날 때마다 한 번씩 저장소를 비우는 역할
  @AfterEach
  public void afterEach() {
    memberRepository.clearStore();
  }

  @Test
  void join() {
    //given
    Member member = new Member();
    member.setName("hello");

    //when - 우리가 저장한 게 repository에 있는 게 맞아?
    Long saveId = memberService.join(member);

    //then
    Member findMember = memberService.findOne(saveId).get();
    assertThat(member.getName()).isEqualTo(findMember.getName());
  }

  @Test
  public void 중복_회원_예외() {
    // given - 이 데이터 기반으로~
    Member member1 = new Member();
    member1.setName("Spring");

    Member member2 = new Member();
    member2.setName("Spring");

    // when - 동직을 검증 : 똑같은 Spring -> 예외 터져야 함
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*
    try {
      memberService.join(member2);
      fail();
    } catch(IllegalStateException e) {
      // 예외 정상적 성공
      assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
*/


    // then - 검증부
  }

  @Test
  void findMembers() {
  }

  @Test
  void findOne() {
  }
}