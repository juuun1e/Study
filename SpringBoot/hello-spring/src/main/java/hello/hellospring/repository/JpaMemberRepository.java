package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

  // jpa는 EntityManager라는 걸로 모든 게 동작한다. == jpa를 사용하려면 em를 주입받아야 한다
  // jpa 라이브러리 -> 스프링부트가 자동으로 EntityManager 생성, 현재 데이터베이스와 연결
  private final EntityManager em;

  public JpaMemberRepository(EntityManager em) {
    this.em = em;
  }

  //jpa가 알아서 쿼리 생성, db에 데이터 저장
  public Member save(Member member) {
    em.persist(member);
    return member;
  }

  public Optional<Member> findById(Long id) {
    Member member = em.find(Member.class, id);
    return Optional.ofNullable(member);
  }

  // pk가 아닌 것들은 JPQL 작서이 필요
  public List<Member> findAll() {
    return em.createQuery("select m from Member m", Member.class)
        .getResultList();
  }

  // JPQL 객체지향쿼리 언어 == 테이블이 아닌 객체(member) 대상으로 쿼리를 날린다. -> SQL로 번역
  // 이미 맵핑이 다 되어있어 한 줄로 간단 해결!
  public Optional<Member> findByName(String name) {
    List<Member> result = em.createQuery("select m from Member m where m.name = :name ", Member.class)
        .setParameter("name", name)
        .getResultList();
    return result.stream().findAny();
  }
}