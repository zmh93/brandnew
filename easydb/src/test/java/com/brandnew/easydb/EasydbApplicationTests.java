package com.brandnew.easydb;

import com.brandnew.easydb.entity.User;
import com.brandnew.easydb.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasydbApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("zmh");
        user.setAge(Short.valueOf("25"));
        user.setBalance(new BigDecimal("9000"));
        System.out.println(userMapper.save(user));
    }

}
