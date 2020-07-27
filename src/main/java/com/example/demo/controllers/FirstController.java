package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/api" )
public class FirstController {
 
    @RequestMapping( value = "/", method = RequestMethod.GET )
    public List<String> index() {
        List<String> s = new ArrayList<>();
        s.add("Docker + AWS CodePipline Tutorial");
        s.add("Learn more at: https://github.com/sixthpoint/Docker-AWS-CodePipeline");
        return s;
    }
}
