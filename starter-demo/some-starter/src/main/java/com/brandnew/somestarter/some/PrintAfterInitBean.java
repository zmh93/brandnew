package com.brandnew.somestarter.some;

import org.springframework.beans.factory.InitializingBean;

public class PrintAfterInitBean implements InitializingBean {
    private String message;
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
