package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 스프링 부트에게 jpa관련 레포지터리와 엔티티 등에 대해 알려주는 어노테이션
// : 이 패키지에 있으니 스캔하여 bean을 생성해 비즈니스 로직에 활용할 수 있도록 해줘~
// @EnableJpaRepositories("com.eazybytes.repository")
// @EntityScan("com.eazybytes.model")
// @EnableWebSecurity :선택사항,웹보안설정, spring boot없이 개발할 때 적용
public class EazyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBackendApplication.class, args);
	}

}
