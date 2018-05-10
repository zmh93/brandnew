package com.brandnew.jpatest.repository;

import com.brandnew.jpatest.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //自定义查询，按照jpa的默认语法 findBy(columnName)
    List<Customer> findByLastName(String lastName);

    //namedQuery预定义查询
    List<Customer> findByFirstName(String name);

    //使用 ?1模糊匹配
    @Query("select c from Customer c where c.firstName = ?1")
    List<Customer> findByFirstName1(String name);

    @Query("select c from Customer c where c.lastName like concat('%',?1,'%')")
    List<Customer> findByLastName2(String name);

    @Query("select c from Customer c where c.lastName like %?1%")
    List<Customer> findByName1(@Param("name") String others);

    //Param的值与=：后面的参数匹配
    @Query("select c from Customer c where c.firstName = :firstName and c.lastName = :lastName")
    List<Customer> findByName2(@Param("firstName") String firstName,@Param("lastName") String lastName);

    //jpql是查询model对象 字段的语言，sql是查询数据库表的字段的语言，使用vativeQuery=true开启使用sql查询
    @Query(nativeQuery = true,value = "select * from Customer c where c.first_name like concat('%',?1,'%')")
    List<Customer> findByName3(@Param("name") String others);



}