package com.eazybytes.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration // 스프링에서 설정 클래스를 정의할 때 사용, 하나 이상의 @Bean이 있는 메서드를 포함
public class ProjectSecurityConfig {

  //SecurityFilterChain Bean을 활용해 맞춤형 보안설정 정의
  //맞춤형 요구사항을 정의하고자 할 때마다 .requestMatches 메서드 호출
  @Bean //시작단계에서 프레임워크가 클래스 안에 정의한 모든 Bean을 스캔
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    /*사용자 정의 보안 설정 : 기본적으로 따르는 설정*/
/* http.authorizeRequests().anyRequest().authenticated();
    http.formLogin(withDefaults())
        .httpBasic(withDefaults());
    return http.build();*/

    /*사용자 정의 보안 설정 : 모든 요청 거부*/
/* http.authorizeRequests()
        .anyRequest().denyAll();
    http.formLogin(withDefaults())
        .httpBasic(withDefaults());
    return http.build();*/

    /*사용자 정의 보안 설정 : 모든 요청 수락*/
/*    http.authorizeRequests()
        .anyRequest().permitAll();
    http.formLogin(withDefaults())
        .httpBasic(withDefaults());
    return http.build();*/

    /*보안과 공개 API를 혼합한 사용자 정의 설정*/
    http.authorizeRequests()
            .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
            .requestMatchers("/notices","/contact").permitAll(); //보안 없이 모든 사용자에게 허가
    http.formLogin(withDefaults())
        .httpBasic(withDefaults());
    return http.build();
  }
}
