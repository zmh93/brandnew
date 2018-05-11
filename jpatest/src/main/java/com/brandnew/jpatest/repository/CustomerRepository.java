package com.brandnew.jpatest.repository;

import com.brandnew.jpatest.dto.Customer;
import com.brandnew.jpatest.dto.CustomerProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.QueryHint;
import java.util.Collection;
import java.util.List;

import static org.hibernate.jpa.QueryHints.HINT_COMMENT;

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

    //使用Sort进行排序
    @Query("select c from Customer c where c.lastName like %:name%")
    List<Customer> findByName3Sort(@Param("name") String others,Sort sort);


    //使用@Modifying进行update操作
    @Modifying
    @Transactional
    @Query("update Customer  c set c.lastName = ?1 where c.firstName = ?2")
    int setFixedFirstnameFor(String firstName, String lastName);

    //使用查询提示 与 默认分页类
    @QueryHints(value = {@QueryHint(name = HINT_COMMENT, value = "查询提示语")})
    @Query("select c from Customer c where c.firstName like %:name% or c.lastName like %:name%")
    Page<Customer> findByName(@Param("name") String name2, Pageable pageable);


    @Query("SELECT c.firstName as firstName,c.lastName as lastName from Customer  c")
    Collection<CustomerProjection> findCustomerProject();
}