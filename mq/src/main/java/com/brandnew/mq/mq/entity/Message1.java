package com.brandnew.mq.mq.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document
public class Message1 implements Serializable {
    private static final long serialVersionUID = 1L;

    private String info;
    private Date   sendTime;
}
