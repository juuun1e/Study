package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// interface는 implements가 아닌 extends, 다중 상속 가능
// SpringDataJpa가 JpaRepository를 받고 있으면 -> 구현체 만들어서 Spring bean에 자동으로 등록
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

  // JPQL : select m from Member m where m.name = ?
  @Override
  Optional<Member> findByName(String name);
}
