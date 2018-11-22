package com.brandnew.differdatasourceexplore.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Pojo {
    @Id
    private Long id;
    private String name;
}
