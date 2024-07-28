package com.clinical.clinicalapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/first")
    public String sayHello() {
        return "Hello momo!";
    }

    @PostMapping("/post")
    public String postSomething(@RequestBody String body) {
        return "You posted: " + body;
    }
}
