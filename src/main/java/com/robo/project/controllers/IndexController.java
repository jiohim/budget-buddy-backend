package com.robo.project.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/v1/")
@RestController
public class IndexController {

    //service

    @GetMapping("index")
    public ResponseEntity<String> indexController(){
        return ResponseEntity.ok("index");
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

}
