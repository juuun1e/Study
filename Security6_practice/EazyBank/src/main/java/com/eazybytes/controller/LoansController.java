package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//사용자의 거래 내역과 잔고 정보르 반환
@RestController
public class LoansController {

    @GetMapping("/myLoans")
    public String getLoansDetails(){

        return "Here are the loans from the DB";
    }

}
