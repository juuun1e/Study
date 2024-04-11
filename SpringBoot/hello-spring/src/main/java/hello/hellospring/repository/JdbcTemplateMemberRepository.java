package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// 순수 JDBC API를 줄이고 줄인 결과 => JdbcTemplate lib
public class JdbcTemplateMemberRepository implements MemberRepository {

  private final JdbcTemplate jdbcTemplate;

  //생성자가 하나만 있다면 @Autowired 생략 가능 -> 스프링이 데이터 소스를 자동으로 인젝션해준다
  public JdbcTemplateMemberRepository(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public Member save(Member member) {
    SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate); // insert 쿼리 따로 짤 필요 없음
    jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

    Map<String, Object> parameters = new HashMap<>();
    parameters.put("name", member.getName());

    // executeAndReturnKey로 키를 받아다가 member에 setId 로 넣어줌
    Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
    member.setId(key.longValue());
    return member;
  }

  // jdbcTemplate에 쿼리 날리고 그 결과를 로우맵퍼를 통해 맵핑하고
  // 그 다음 리스트로 받아서 옵션으로 바꿔 반환
  @Override
  public Optional<Member> findById(Long id) {
    List<Member> result = jdbcTemplate.query("select * from member where id = ? ", memberRowMapper(), id);
    return result.stream().findAny();
  }

  @Override
  public Optional<Member> findByName(String name) {
    List<Member> result = jdbcTemplate.query("select * from member where name = ? ", memberRowMapper(), name);
    return result.stream().findAny();
  }

  @Override
  public List<Member> findAll() {
    return jdbcTemplate.query("select * from member", memberRowMapper());
  }

  // java8 lamda 스타일
  // result set 결과를 mapping해서 객체 생성 -> 넘겨줌
  private RowMapper<Member> memberRowMapper() {
    return (rs, rowNum) -> {
      Member member = new Member();
      member.setId(rs.getLong("id"));
      member.setName(rs.getString("name"));
      return member;
    };
  }
}
