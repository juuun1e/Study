package com.eazybytes.config;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


// [정리] SpringSecurity프레임워크는 인증을 진행하려 할 때마다 인증 요청을 Dao에게 전달하고
// DaoProvider가 개발자에서 사용하도록 요구한 UserDetailsService의 구현클래스를 찾을 것.
// [!!] 지금과 같은 상황
// : 두 개의 구혐클래스를 찾아낼 것임 (EazyBankUserDetails와 Config파일 안에 있는 UserDetailsService Bean)
// -> 혼동 ... Dao에서 충돌 발생하여 에러 발생 -> jdbc 주석처리


// UserDetailsService 인터페이스를 오버라이드하여 LoadUserByUsernamw() 코드를 직접 작성해야 함
// 메소드 내부에서는 정보를 UserDetails객체로 변화하여 프레임워크로 반환해야 함
@Service
public class EazyBankUserDetails implements UserDetailsService {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    String userName, password;
    List<GrantedAuthority> authorities;
    List<Customer> customer = customerRepository.findByEmail(username);
    //username을 넘겨 customerRepository 메소드 호출

    if (customer.size() == 0) {
      throw new UsernameNotFoundException("User details not found for the user : " + username);
    } else{ // 데이터베이스에 저장해뒀던 아이디와 비밀번호를 getEmail과 getPwd의 도움으로 반환
      userName = customer.get(0).getEmail();
      password = customer.get(0).getPwd();
      authorities = new ArrayList<>();
      //User클래스에서 권한 정보를 GrantAuthority 형태로 받아들이고 있음 -> SimpleGrantAuthority클래스를 생성
      authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
    } // 받아온 값을 User클래스 생성자에게 넘김, DaoAuthenticationProvider에게 줄 수 있도록,
      // Dao에서는 데이터베이스에서 가져온 비밀번호와 유저가 입력한 비밀번호를 비교
    return new User(userName,password,authorities);
  }

}