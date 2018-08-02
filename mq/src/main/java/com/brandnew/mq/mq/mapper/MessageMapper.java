package com.brandnew.mq.mq.mapper;

import com.brandnew.mq.mq.entity.Message1;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageMapper extends MongoRepository<Message1,Long> {

}
