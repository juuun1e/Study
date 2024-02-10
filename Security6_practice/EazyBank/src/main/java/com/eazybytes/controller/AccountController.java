package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/myAccount")
    public String getAccountDetails(){
        //'DB의 계좌 정보입니다.'라는 문자열 리턴
        return "Here are the account from the DB";
    }
}
