package com.brandnew.mq.mq.sender;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

    @Bean
    Queue queue() {
        return new Queue(MqConstant.queueName1, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(MqConstant.topicExchangeName);
    }

    @Bean
    Binding binding1(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(MqConstant.queueName1);
    }


    @Bean
    Binding binding2(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(MqConstant.queueName2);
    }
}
