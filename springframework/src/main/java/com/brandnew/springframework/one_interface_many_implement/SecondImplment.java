package com.brandnew.springframework.one_interface_many_implement;

import org.springframework.stereotype.Service;

@Service("oneInterface2")
public class SecondImplment implements IOneInterface {
    @Override
    public String intro() {
        return "Second is me!";
    }
}
