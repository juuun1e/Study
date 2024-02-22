package com.eazybytes.config;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EazyBankUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

  // 아래 authenticate로직 1)2)를 위해 Bean 주입 필요
  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  // 1) 저장 시스템에서부터 유저 세부사항을 로딩하고 2) 비밀번호 비교하는 authenticate 로직을 정확하게 정의하는 것이 개발자 책임
  // 이후에 authentication의 성공 여부에 대한 정보가 담겨있는 authentication객체를 생성해야 함
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    // 유저이름과 비밀번호 불러오는 중
    String username = authentication.getName();
    String pwd = authentication.getCredentials().toString();

    // 유저이름이 이메일이기에 findByEmail메소드를 사용하여 유저 세부사항을 파악하고 있음
    List<Customer> customer = customerRepository.findByEmail(username);

    if (customer.size() > 0) { // 대상이 존재한다면 데이터베이스로부터의 기록을 성공적으로 불러왔는지 확인

      // 기록이 있다면 유저가 입력한 비밀번호 vs 기록상의 비밀번호 일치 여부 확인 : passwordEncoder.matches()
      if (passwordEncoder.matches(pwd, customer.get(0).getPwd())) {
        // 일치하다면 if 블록 실행, 유저의 authorities세부사항(=role)를 덧붙이는 로직
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole())); //Role문자열 값을 SimpleGrantedAuthority클래스로 변환
        // 모든 정보를 모아 토큰을 새롭게 생성 -> 생성자를 살펴보면 ProviderManager에게 authentication이 성공적으로 이루어졌다고 알림
        return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
      } else { // 대상이 없다면 Exception처리
        throw new BadCredentialsException("Invalid password!");
      }

    }else {
      throw new BadCredentialsException("No user registered with this details!");
    }
  }

  //SpringSecurity프레임워크에 전달하고 싶었던 사항은 인증에 대한 유저 이름, 비밀번호 스타일 등을 설정하고 싶다는 점.
  // -> DaoAuthenticationProvider로 이동하여 새로운 AuthenticationProvider에 코드 전체를 복사하기 위해 supports() 찾아봐야 함.
  @Override
  public boolean supports(Class<?> authentication) {
    return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
  }
}
