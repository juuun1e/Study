package com.eazybytes.controller;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// REST서비스를 만들어 유저가 직접 등록하도록 @RestController
// -> 등록 과정: 유저가 입력한 자격 증명을 받아 데이터베이스에 저장하고 싶음.
// 같은 자격증명을 유저가 사용하여 로그인하는 데 사용할 수 있음
@RestController
public class LoginController {

  @Autowired
  private CustomerRepository customerRepository;

  @PostMapping("/register") //RequestBody는 이메일이 무엇인지 비밀번호와 역할이 무엇인지 판단 가능
  public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
    Customer savedCustomer = null;
    ResponseEntity response = null;
    try {
      savedCustomer = customerRepository.save(customer);
      if (savedCustomer.getId() > 0) {
        response = ResponseEntity
            .status(HttpStatus.CREATED)
            .body("Given user details are successfully registered");
      }
    } catch (Exception ex) {
      response = ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("An exception occured due to " + ex.getMessage());
    }
    return response;
  }

}