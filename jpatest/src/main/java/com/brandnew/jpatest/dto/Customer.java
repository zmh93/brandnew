package com.brandnew.jpatest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Customer.findByFirstName", query = "select c from Customer c where c.firstName  = ?1")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long          id;
    private String        firstName;
    private String        lastName;
    @OneToMany
    @JoinColumn(name = "cId")
    private List<MyOrder> myOrders;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName  = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
