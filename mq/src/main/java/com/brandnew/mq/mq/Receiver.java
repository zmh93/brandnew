package com.brandnew.mq.mq;

import com.brandnew.mq.domain.User;
import com.brandnew.mq.mapper.UserMapper;
import com.brandnew.mq.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.nio.channels.Channel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@Component
public class Receiver implements IUserService{

    private CountDownLatch                latch       = new CountDownLatch(5);
    @Autowired
    private UserMapper   userMapper;

    public void receiveMessage(Object message) {

        System.out.println("Received <" + message.toString() + ">");
        saveOrUpdate();
        latch.countDown();
        System.out.println(latch.getCount());
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    @Override
    public void saveOrUpdate() {

        User user = new User();
        user.setUsername("sss");
        user.setPassword("ssss");
        userMapper.insert(user);

}


}
