package com.brandnew.mq.mq.sender;

public class MqConstant {
    //交换机
    public static final String topicExchangeName = "zmh-topic-exchange";
    public static final String fanoutExchangeName = "zmh-fanout-exchange";
    public static final String directExchangeName = "zmh-direct-exchange";


    public static final String routingKeyAll = "com.zmh.*";
    public static final String routingKey1 = "com.zmh.queue1";
    public static final String routingKey2 = "com.zmh.queue2";

}
