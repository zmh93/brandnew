package com.brandnew.jpatest.repository;

import com.brandnew.jpatest.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
 * Title: CustomerSpecificationRepository
 * Description: 常用的查询方法
 * @author zhaomenghui
 * @version 2018/5/11
 */
public interface CustomerSpecificationRepository extends JpaRepository<Customer,Long>,JpaSpecificationExecutor<Customer> {}
