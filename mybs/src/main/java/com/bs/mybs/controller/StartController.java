package com.bs.mybs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/start.do")
public class StartController {
    @GetMapping("/springboot")
    public String startSpringBoot() {
        System.out.println("");
        return "Welcome to the world of Spring Boot!";
    }
}
