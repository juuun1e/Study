package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    // 문의 게시판
    @GetMapping("/contact")
    public String getContactDetails(){

        return "Inquiry details are saved to the DB";
    }
}
