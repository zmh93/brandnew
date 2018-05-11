package com.brandnew.jpatest.repository;

import com.brandnew.jpatest.dto.MyOrder;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface MyOrderRepository extends JpaSpecificationExecutor<MyOrder>,CrudRepository<MyOrder,Long> {}
