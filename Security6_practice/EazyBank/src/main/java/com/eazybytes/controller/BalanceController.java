package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//사용자의 거래 내역과 잔고 정보르 반환
@RestController
public class BalanceController {

    @GetMapping("/myBalance")
    public String getBalanceDetails(){
        return "Here are the balance from the DB";
    }

}
