package com.brandnew.mq;

import com.brandnew.mq.domain.User;
import com.brandnew.mq.mapper.UserMapper;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectAll();
        User       user  = users.get(0);
        System.out.println(user);
    }

}
