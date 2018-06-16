package com.brandnew.jpatest;

import com.brandnew.jpatest.dto.Customer;
import com.brandnew.jpatest.dto.MyOrder;
import com.brandnew.jpatest.repository.CustomerRepository;
import com.brandnew.jpatest.repository.CustomerSpecificationRepository;
import com.brandnew.jpatest.repository.MyOrderRepository;
import com.brandnew.jpatest.util.SpecificationFactory;
import org.hibernate.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        repository.findByName3Sort("a", sort).forEach(System.out::println);
    }

    @Test
    public void testModifying() {
        System.out.println(repository.setFixedFirstnameFor("zhaozhao", "zhao"));
        repository.findAll().forEach(System.out::println);
    }

    @Test
    public void testHints() {
        Pageable       page       = PageRequest.of(0, 3);
        Page<Customer> pageResult = repository.findByName("a", page);
        pageResult.getContent().forEach(System.out::println);
    }

    @Test
    public void testProjection() {
        repository.findCustomerProject().forEach(x -> System.out.println(x.getFirstName()));
    }

    @Autowired
    private CustomerSpecificationRepository specificationRepository;

    @Test
    public void testSpecification() {
        Specification<Customer> spec     = SpecificationFactory.containsLike("firstName", "a");
        Pageable                pageable = PageRequest.of(0, 3, Sort.Direction.DESC, "id");
        Page<Customer>          page     = specificationRepository.findAll(spec, pageable);
        page.getContent().forEach(System.out::println);

    }

    @Autowired
    private MyOrderRepository myOrderRepository;

    @Test
    public void saveMyOrders() {
        repository.save(new Customer("Jack", "Bauer"));
        Optional<Customer> byId = repository.findById(1L);
        Customer           customer = byId.get();
        List<MyOrder> myOrders = new ArrayList<>();
        myOrders.add(myOrderRepository.save(new MyOrder("柿饼", "3000", customer)));
        myOrders.add(myOrderRepository.save(new MyOrder("苹果", "1000", customer)));
        myOrders.add(myOrderRepository.save(new MyOrder("橘子", "2000", customer)));
        myOrders.add(myOrderRepository.save(new MyOrder("香蕉", "10000", customer)));
        customer.setMyOrders(myOrders);
        repository.save(customer);
//        myOrderRepository.findAll().forEach(System.out::println);
        System.out.println(customer.getMyOrders());
    }

    @Test
    public void testForTemp() {
        System.out.println(repository.findByFirstName1("zhao"));
    }

    @Test
    public void testSpecification1() {
        Specification<MyOrder> spec = new Specification<MyOrder>() {
            @Override
            public Predicate toPredicate(Root<MyOrder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //声明并创建MyOrder的criteriaQuery对象
                CriteriaQuery<MyOrder> ql = cb.createQuery(MyOrder.class);
                Join<Customer, MyOrder> myOrderJoin = root.join("customer", JoinType.INNER);
                ql.select(myOrderJoin);
                return ql.getRestriction();
            }
        };
        resultPrint(spec);
    }

    /***
     *输出分页信息
     **/
    private void resultPrint(Specification<MyOrder> spec) {
        //分页查询
        Pageable pageable = PageRequest.of(0,10, Sort.Direction.DESC,"id");
        //查询的分页结果
        Page<MyOrder> page =myOrderRepository.findAll(spec,pageable);
        System.out.println(page);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        for (MyOrder c:page.getContent()){
            System.out.println(c.toString());
        }
    }
}
