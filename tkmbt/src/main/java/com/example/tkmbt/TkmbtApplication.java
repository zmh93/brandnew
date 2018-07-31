package com.example.tkmbt;

import com.example.tkmbt.domain.Person;
import com.example.tkmbt.mapper.PersonMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan(basePackages = "com.example.tkmbt")
@RestController
public class TkmbtApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkmbtApplication.class, args);
    }


    @Autowired
    private PersonMapper personMapper;

    @GetMapping("allPerson")
    public Object getAllPerson() {
        Person p = new Person();
        p.setId(1);
        return personMapper.select(p);
    }
}
