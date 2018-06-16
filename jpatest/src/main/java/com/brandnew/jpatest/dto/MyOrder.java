package com.brandnew.jpatest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long     id;
    private String   name;
    private String   price;
    @OneToOne
    @JoinColumn(name = "cId", insertable = false, updatable = false)
    private Customer customer;

    public MyOrder(String name, String price,Customer customer) {
        this.name = name;
        this.price = price;
        this.customer = customer;
    }
}
