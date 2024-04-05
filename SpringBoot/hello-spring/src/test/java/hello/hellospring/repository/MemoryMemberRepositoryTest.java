package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// 테스트는 서로 순서와 관계없이, 의존관계 없이 설계 되어야 한다.
class MemoryMemberRepositoryTest {
  MemoryMemberRepository repository = new MemoryMemberRepository();

  // 테스트 실행이 되고 끝날 때마다 한 번씩 저장소를 비우는 역할
  @AfterEach
  public void afterEach() {
    repository.clearStore();
  }

  @Test
  public void save() {
    Member member = new Member();
    member.setName("spring");

    repository.save(member);

    Member result = repository.findById(member.getId()).get();
    // System.out.println("result = " + (result == member));
    // Assertions.assertEquals(member, result); //org.junit.jupiter.api
    assertThat(member).isEqualTo(result); //org.assertj.core.api
  }

  @Test
  public void findByName() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    // Optional<Member> result = repository.findByName("spring1");
    Member result = repository.findByName("spring1").get();

    assertThat(result).isEqualTo(member1);

  }

  @Test
  public void findByAll() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    List<Member> result = repository.findAll();
    assertThat(result.size()).isEqualTo(2);
  }
}
