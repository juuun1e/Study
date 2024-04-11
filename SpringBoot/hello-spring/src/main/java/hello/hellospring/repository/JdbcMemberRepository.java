package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.jdbc.datasource.DataSourceUtils;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class JdbcMemberRepository implements MemberRepository {

  // DB연결을 위해 필요한 소스 (접속 정보) <- 스프링한테 주입 받아야 한다. (application.properties)
  private final DataSource dataSource;

  public JdbcMemberRepository(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public Member save(Member member) {
    String sql = "insert into member(name) values(?)";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // (쿼리, id값 자동 생성)

      pstmt.setString(1, member.getName()); // ?와 1 매핑되어 member.name값을 넣음

      pstmt.executeUpdate(); //DB의 실제 into 쿼리가 날라감
      rs = pstmt.getGeneratedKeys(); // 생성한 데이터의 key(id)를 반환해줌

      if (rs.next()) {
        member.setId(rs.getLong(1));
      } else {
        throw new SQLException("id 조회 실패");
      }
      return member;
    } catch (Exception e) {
      throw new IllegalStateException(e);
    } finally {
      close(conn, pstmt, rs); // 사용한 자원 끊어주기 -> 커넥션 계속 쌓이면 대장애 발생
    }
  }

  // 회원 조회
  @Override
  public Optional<Member> findById(Long id) {
    String sql = "select * from member where id = ?";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setLong(1, id);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        Member member = new Member();
        member.setId(rs.getLong("id"));
        member.setName(rs.getString("name")); // 값이 있다면 멤버 객체를 만들어 반환
        return Optional.of(member);
      } else {
        return Optional.empty();
      }

    } catch (Exception e) {
      throw new IllegalStateException(e);
    } finally {
      close(conn, pstmt, rs);
    }
  }

  @Override
  public List<Member> findAll() {
    String sql = "select * from member";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      pstmt = conn.prepareStatement(sql);

      rs = pstmt.executeQuery();

      // list collection 에 담아 루프 돌리면서 .add로 멤버를 담아 반환
      List<Member> members = new ArrayList<>();
      while (rs.next()) {
        Member member = new Member();
        member.setId(rs.getLong("id"));
        member.setName(rs.getString("name"));
        members.add(member);
      }

      return members;
    } catch (Exception e) {
      throw new IllegalStateException(e);
    } finally {
      close(conn, pstmt, rs);
    }
  }

  @Override
  public Optional<Member> findByName(String name) {
    String sql = "select * from member where name = ?";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, name);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        Member member = new Member();
        member.setId(rs.getLong("id"));
        member.setName(rs.getString("name"));
        return Optional.of(member);
      } else {
        return Optional.empty(); // 없는 경우
      }

    } catch (Exception e) {
      throw new IllegalStateException(e);
    } finally {
      close(conn, pstmt, rs);
    }
  }

  // framwork를 통해 데이터베이스 커넥션을 사용하는 경우
  // DataSourceUtils.getConnection()로 가져와야 한다.
  private Connection getConnection() {
    return DataSourceUtils.getConnection(dataSource);
  }

  // 자원 close도 굉장히 복잡한 과정 : 자원 역순으로 result set ...
  private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if (pstmt != null) {
        pstmt.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if (conn != null) {
        close(conn);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // 닫을 때도 dataSourceUtils로 !!!
  private void close(Connection conn) throws SQLException {
    DataSourceUtils.releaseConnection(conn, dataSource);
  }
}

