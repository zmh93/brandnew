package com.brandnew.shardingjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ShardingjdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingjdbcApplication.class, args);
    }

    @Autowired
    private TestMapper testMapper;

    @GetMapping
    public Object getAll() {
        return testMapper.selectAll();
    }

    @PostMapping
    public Object post(Test test) {
        return testMapper.insert(test);
    }
}
