package hello.hellospring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // @ == 매핑, jpa가 관리하는 entity
public class Member {

  // id == pk
  // IDENTITY == DB가 알아서 생성해주는 식별자
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
