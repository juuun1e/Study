package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                        .requestMatchers("/notices","/contact","/register").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    // 애플리케이션 메모리에 다수의 사용자 계정 생성하기 방법1 -withDefaultPasswordEncoder
    // bean 생성을 위해 이 메소드에서 반환하려는 객체가 무엇이든 InMemoryUserDetailsManager 유형 : Spring프레임워크에 의해 Bean으로 변경되고, Spring Security 프레임워크에 의해 동일한 Bean이 됨
    /*@Bean
    public InMemoryUserDetailsManager userDetailsService(){

        //User클래스의 도움을 받아 withDefaultPasswordEncoder메소드를 호출 (일반 텍스트 비밀번호 사용)
        //User - SpringSecurityProvider 클래스로, UserDetails 인터페이스를 구현함
        UserDetails admin = User.withDefaultPasswordEncoder() //권장하지 않음, 낮은 안전성
            .username("admin")
            .password("12345")
            .authorities("admin")
            .build(); // 마지막으로 호출 - 제공된 유저이름과 비밀번호를 가진 새로운 유저 객체를 생성
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("12345")
            .authorities("read")
            .build();
        //유저 무한 생성 가능, 두 유저객체를 생성하고 Manager 생성자에 전달함
        return new InMemoryUserDetailsManager(admin,user);
        //InMemoryUserDetailsManager 생성자는 n개의 유저를 입력 받고 전달받은 유저 목록을 반복할 for문 존재
        //최종적으로 createUser라는 메소드를 호출함
    }*/


    //애플리케이션 메모리에 다수의 사용자 계정 생성하기 방법2 - NoOpPasswordEncoder Bean
    //userDetailsManager Bean을 생성하고 구축할 때마다
    //DaoAuthenticationProvider는 InMemory 안에 있는 메소드를 호출하여 사용자 인증하려고 함
    //→ 호출한 메서드 : loadUserByUsername , 리턴타입(UserDetails)
/*    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        //username을 직접 사용하지 않고 .withUsername메소드 호출
        UserDetails admin = User.withUsername("admin")
            .password("12345")
            .authorities("admin")
            .build();
        UserDetails user = User.withUsername("user")
            .password("12345")
            .authorities("read")
            .build();
        return new InMemoryUserDetailsManager(admin, user);
        //InMemoryUserDetailsManager의 도움으로 UserDetails구성
    } */
    //-> 더 이상 사용 안함. Jdbc방식의 인증 사용

/*    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
        // DataSouce객체가 JdbcUserDetailsManager에게 넘어갈 때마다 스프링부트는 데이터 소스 객체를 자동적으로 웹 애플리케이션 내부에 생성,
        // JdbcUserDetailsManager에게 데이터베이스를 생성하였으며 그에 대한 정보는 이  DataSource 에 있습니다~ 하고 알려주는 것
        // : Manager 객체 생성의 이유
    }*/


    // 정상적 수행 = 반드시 웹 어플리케이션 안에서 비밀번호와 할당량 유형의 Bean을 생성해야 함
    // 그러므로 동일한 작업을 위해 PasswordEncoder유형의 Bean을 반환할 새로운 메소드 생성
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
        // 프러덕션 환경에서의 사용을 보안상 권장되지 않음
    }


}
