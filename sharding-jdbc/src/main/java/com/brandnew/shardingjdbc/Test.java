package com.brandnew.shardingjdbc;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Test {
    @Id
    private Long id;

    private Long orderId;

    private String name;

    private Integer age;
}