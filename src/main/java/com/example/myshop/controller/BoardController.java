package com.example.myshop.controller;

import com.example.myshop.security.AuthUser;
import com.example.myshop.security.LoginUser;
import com.example.myshop.utils.ServerInfo;
import org.apache.catalina.Server;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/boards")
public class BoardController {
    // GET /boards - 1page의 결과를 달라.
    // GET /boards?page=2 - 2page의 결과를 달라.
    @GetMapping
    public String list(
            @AuthUser LoginUser loginUser,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "searchKind", required = false) String searchKind,
            @RequestParam(name = "searchStr", required = false) String searchStr
    ){
//
//        LoginUser loginUser = (LoginUser)SecurityContextHolder
//                .getContext().getAuthentication().getPrincipal();
        if(loginUser != null){
            System.out.println("----------------------");
            System.out.println(loginUser.getId());
            System.out.println(loginUser.getName());
            System.out.println(loginUser.getEmail());
            System.out.println("----------------------");
        }
        System.out.println("page : " + page);
        System.out.println("searchKind : " + searchKind);
        System.out.println("searchStr : " + searchStr);
        return "list"; // view name 을 리턴한다.
    }

    @GetMapping(path="{boardId}")
    public String read(@PathVariable(name="boardId")long boardId){
        System.out.println("boardId :"+boardId);
        return "view";
    }

    @GetMapping(path ="/wirte")
    public String wirteform(){
        return "wirteform";//이름 , 제목 , 내용을 입력하는 폼
    }

    @PostMapping
    public String wirte(@RequestParam(name="name",required = true)String name
            ,@RequestParam(name="title",required = true)String title
            ,@RequestParam(name="content",required = true)String content){
        System.out.println("name = "+name);
        System.out.println("title= "+title);
        System.out.println("content= "+content);
        return "write";
    }



}
