package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/" )
public class FirstController {
 
    @GetMapping("/api" )
    public List<String> index() {
        List<String> s = new ArrayList<>();
        s.add("Docker + AWS CodePipline Tutorial");
        s.add("Learn more at: https://github.com/sixthpoint/Docker-AWS-CodePipeline");
        return s;
    }
}
