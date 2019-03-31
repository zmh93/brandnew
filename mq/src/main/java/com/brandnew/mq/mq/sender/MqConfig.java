package com.brandnew.mq.mq.sender;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

    @Bean
    FanoutExchange exchange1() {
        return new FanoutExchange(MqConstant.fanoutExchangeName);
    }

    @Bean
    TopicExchange exchange2() {
        return new TopicExchange(MqConstant.topicExchangeName);
    }

    @Bean
    DirectExchange exchange3() {
        return new DirectExchange(MqConstant.directExchangeName);
    }

    @Bean
    Queue queue1() {
        return new Queue(MqConstant.routingKey1,false);
    }

    @Bean
    Queue queue2() {
        return new Queue(MqConstant.routingKey2,false);
    }

    @Bean
    Binding binding1() {
        return BindingBuilder.bind(queue1()).to(exchange1());
    }

    @Bean
    Binding binding11() {
        return BindingBuilder.bind(queue1()).to(exchange2()).with(MqConstant.routingKey1);
    }
    @Bean
    Binding binding12() {
        return BindingBuilder.bind(queue2()).to(exchange2()).with(MqConstant.routingKey2);
    }

    @Bean
    Binding binding3() {
        return BindingBuilder.bind(queue1()).to(exchange3()).with(MqConstant.routingKey1);
    }
}
