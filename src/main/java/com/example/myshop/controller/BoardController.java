package com.example.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class BoardController {
    // GET /boards
    @GetMapping
    public String list(){
        return "list"; //view name을 리턴한다.
    }
}
