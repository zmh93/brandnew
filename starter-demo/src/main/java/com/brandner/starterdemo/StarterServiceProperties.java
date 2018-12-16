package com.brandner.starterdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("com.brandner")
public class StarterServiceProperties {
    private String config;
    
    public void setConfig(String config) {
        this.config = config;
    }
    
    public String getConfig() {
        return config;
    }
 }