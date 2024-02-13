package com.eazybytes.filter;

import com.eazybytes.constants.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//토큰의 유효성을 검증하는 역할의 필터 -> 인증이 시도되기 전에 시행되어야 함.
public class JWTTokenValidatorFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //클라이언트에서 받을 JWT 토큰의 유효성 검증 로직
        //getHeader() 사용 : 권한 부여 헤더 값을 가져오려고 시도 -> SecurityConstants에서 Authorization 이름의 헤더 값을 받아옴
        String jwt = request.getHeader(SecurityConstants.JWT_HEADER);
        if (null != jwt) {
            try {  // Keys.hmacShaKeyFor() 이용하여 비밀 키 다시 생성하기 위해
                SecretKey key = Keys.hmacShaKeyFor( //백엔드 SecurityConstants에 있는 비밀키 값을 보냄
                        SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));

                //검증과정 중 같은 비밀 키를 다시 사용하고 있는지 확인해야 함
                //Jwts클래스를 이용하여 parserBuilder라는 메소드를 호출 -> 안에 Singning Secret Key(=백엔드에 있는 값과 동일)를 호출
                Claims claims = Jwts.parser()
                        .verifyWith(key)
                        .build()
                        .parseSignedClaims(jwt) //받은 토큰을 보내야 함
                        .getPayload(); // 전송이 완료된 후 바디값을 읽는 데 집중,
                        // 특정값을 나타내는 value토큰이라면 헤더 부분에서 서명부분을 읽고 싶지 않기 때문에 getPayload()호출 -> claims를 가져옴

                // Claims 사용하여 유저의 id와 권한을 가져올 수 있음
                String username = String.valueOf(claims.get("username"));
                String authorities = (String) claims.get("authorities");
                // UsernamePasswordAuthenticationToken 종류의 인증객체를 생성할 수 있음
                // -> 스프링시큐리티 프레임워크에 해당 jwt토큰을 유효화 -> 인증과정이 성공적이라고 추정할 것 (직접 인증객체를 생성하는 이유)
                Authentication auth = new UsernamePasswordAuthenticationToken(username, null,
                        AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));

                // 해당인증객체를 아래 메서드를 호출하여 SecurityContextHolder에 넣어둬야 하는 이유
                SecurityContextHolder.getContext().setAuthentication(auth);

                // jwt 토큰 라이브러리가 생성해둔 비밀키를 기반으로 jwt토큰을 전달하려고 할 때 내부적으로 해시 값을 계산하여 일치여부를 확인할 것
                // 일치하지 않으면 예외처리
            } catch (Exception e) {
                throw new BadCredentialsException("Invalid Token received!");
            }

        } // 필터 체인 속 다음 필터를 호출
        filterChain.doFilter(request, response);
    }

    //JWTTokenValidatorFilter가 로그인 작업 중을 제외한 모든 api호출에 대해 실행되는 설정
    //'/user'일 때 실행되면 안됨
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {

        return request.getServletPath().equals("/user");
    }

}
