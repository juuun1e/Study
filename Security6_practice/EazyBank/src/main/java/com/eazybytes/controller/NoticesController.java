package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    // 공지사항 게시판
    @GetMapping("/notices")
    public String getNoticesDetails(){

        return "Here are the notices details from the DB";
    }
}
