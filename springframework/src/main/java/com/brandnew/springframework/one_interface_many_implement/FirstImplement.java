package com.brandnew.springframework.one_interface_many_implement;

import com.sun.xml.internal.fastinfoset.QualifiedName;
import org.springframework.stereotype.Service;

@Service("oneInterface1")
public class FirstImplement implements IOneInterface {
    @Override
    public String intro() {
        return "First is me!";
    }
}