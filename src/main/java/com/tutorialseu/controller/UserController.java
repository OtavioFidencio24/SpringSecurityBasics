package com.tutorialseu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/home")
    public String userHome (){
        return "Welcome to the user Home page";
    }
}
