package com.brandnew.jpatest;

import com.brandnew.jpatest.dto.Customer;
import com.brandnew.jpatest.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpatestApplicationTests {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void contextLoads() {
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));
        repository.save(new Customer("Bauer", "Dessler"));
    }

    @Test
    public void primaryQuery() {
        System.out.println(repository.getOne(2L));
        repository.deleteById(2L);
        repository.findAll().forEach(System.out::println);
    }

    @Test
    public void juniorQuery() {
        repository.findByLastName("Dessler").forEach(System.out::println);
    }

    @Test
    public void juniorNamedQuery() {
        System.out.println(repository.findByFirstName("Michelle"));
    }

    @Test
    public void seniorQuery() {
//        repository.findByFirstName1("Michelle").forEach(System.out::println);
//        repository.findByLastName2("a").forEach(System.out::println);
//        System.out.println(repository.findByName1("David", "Palmer"));
//        repository.findAll().forEach(System.out::println);
        System.out.println(repository.findByName3("a"));
    }

    @Test
    public void testSort() {
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        repository.findByName3Sort("a",sort).forEach(System.out::println);
    }
}
