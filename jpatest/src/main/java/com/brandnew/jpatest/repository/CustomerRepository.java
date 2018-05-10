package com.brandnew.jpatest.repository;

import com.brandnew.jpatest.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}