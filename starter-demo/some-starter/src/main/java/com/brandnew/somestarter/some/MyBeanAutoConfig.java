package com.brandnew.somestarter.some;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanAutoConfig {

    @Bean
    @ConfigurationProperties(prefix = "init")
    @ConditionalOnMissingBean(PrintAfterInitBean.class)
    @ConditionalOnProperty(prefix = "init",value = "message")
    public PrintAfterInitBean printAfterInitBean() {
        return new PrintAfterInitBean();
    }
}
