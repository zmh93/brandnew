package com.example.tkmbt;

import com.example.tkmbt.domain.Person;
import com.example.tkmbt.mapper.PersonMapper;
import com.sun.scenario.effect.impl.prism.PrImage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TkmbtApplicationTests {

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void contextLoads() {
        System.out.println(personMapper.selectAll());
    }

    @Test
    public void testOne() {
        Person p = new Person();
        p.setId(1);
        System.out.println(personMapper.select(p).get(0).getCreateTime());
        System.out.println(personMapper.selectOne(p).getCreateTime());
    }
}
