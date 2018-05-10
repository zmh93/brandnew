package com.brandnew.jpatest;

import com.brandnew.jpatest.dto.Customer;
import com.brandnew.jpatest.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpatestApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void contextLoads() {
        customerRepository.save(new Customer("zhao", "menghui"));
    }

    @Test
    public void query() {
        System.out.println(customerRepository.getOne(1L));
    }

}
