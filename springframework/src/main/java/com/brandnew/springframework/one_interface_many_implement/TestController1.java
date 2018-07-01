package com.brandnew.springframework.one_interface_many_implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController1 {
    @Autowired
    private IOneInterface oneInterface1;
    @Autowired
    private IOneInterface oneInterface2;
    @GetMapping("test1")
    public String test1() {
        return oneInterface1.intro();
    }

    @GetMapping("test2")
    public String test2() {
        return oneInterface2.intro();
    }
}
