package com.tutorialseu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/secured")
    public String secureEndpoint (){
        return "this is a secure endpoint accessible only by authenticate users.";
    }

    @GetMapping("public")
    public String publicEndpoint () {
        return "this is a public endpoint accessible by anyone!";
    }
}
