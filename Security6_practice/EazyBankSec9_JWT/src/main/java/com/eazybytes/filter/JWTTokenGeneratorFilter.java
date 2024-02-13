package com.eazybytes.filter;

import com.eazybytes.constants.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

// 각 요청당 한 번만 실행되도록 원하기 때문에 스프링 프레임워크 안에 있는 OncePerRequestFilter를 상속
public class JWTTokenGeneratorFilter extends OncePerRequestFilter {

    //토큰 생성 필터
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 해당 필터가 호출될 때 유저의 인증이 성공적일 것 -> SecurityContextHolder. 을 이용하여 현재 인증된 유저의 정보를 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // authentication이 NULL이 아니라면
        if (null != authentication) { //SecurityConstants 안에 비밀값(JWT_KEY)을 기반으로 SecretKey를 생성
            SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));

            //key를 생성한 뒤 Jwts.builder()를 이용하여 토큰을 생성하고자 함
            String jwt = Jwts.builder()
                    .issuer("Eazy Bank").subject("JWT Token") //issuer- 토큰을 발행하는 개인 혹은 조직, subject- 원하는 값 넣어도 됨
                    .claim("username", authentication.getName()) //claim- 로그인 된 유저의 id와 권한을 채울 수 있음
                    .claim("authorities", populateAuthorities(authentication.getAuthorities()))
                    .issuedAt(new Date()) //issuedAt- 클라이언트에게 토큰이 발행될 때의 날짜값을 설정
                    .expiration(new Date((new Date()).getTime() + 30000000)) //토큰 만료시간 설정- 현재 시간부터 +30000000 밀리초(8시간)
                    .signWith(key).compact();//signWith- 토큰 속 모든 내용에 디지털 서명 : 메소드 사용을 위해 생성된 비밀key값 사용, compact()호출
            response.setHeader(SecurityConstants.JWT_HEADER, jwt); // jwt토큰 생성되고 헤더를 설정하여 해당 토큰을 응답에 전송
        }

        filterChain.doFilter(request, response);
    }

    //shouldNotFilter의 목적 : 메소드에 조건을 제공한다면  그 조건에 따라 필터를 실행하지 않도록 하는 것
    //조건 : 오로지 로그인 과정 중에만 실행되어야 함. -> 후속 요청에서 jwt토큰이 계속해서 생성되는 것을 막기 위함
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getServletPath().equals("/user");
    }

    //populateAuthorities() - 필터 자체에서 모든 권한 정보를 읽어와 문자열값을 형성하며 (,)구분자로 구분 됨.
    private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
        Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
    }

}
