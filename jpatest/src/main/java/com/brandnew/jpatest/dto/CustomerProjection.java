package com.brandnew.jpatest.dto;

import org.springframework.beans.factory.annotation.Value;

public interface CustomerProjection {
    @Value("#{target.firstName+' '+target.lastname}")
    String getFullName();

    String getFirstName();

    String getLastName();
}
