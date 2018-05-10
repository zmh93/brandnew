package com.brandnew.jpatest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping(value = "index")
    public Object index() {
        return "hello,there";
    }
}
