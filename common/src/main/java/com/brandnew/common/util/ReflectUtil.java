package com.brandnew.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.*;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ReflectUtil {
    public static void main(String[] args) throws Exception {
        Pojo                        pojo     = new Pojo("1", "2", "3", "4");
        Class<Pojo>                 clz      = Pojo.class;
        BeanInfo                    beanInfo = Introspector.getBeanInfo(clz,Object.class);
        PropertyDescriptor[] pds      =  beanInfo.getPropertyDescriptors();
        List<PropertyDescriptor> collect = Arrays.stream(pds).sorted((pd1, pd2) -> {
            try {
                PropertyIndex index1 = clz.getDeclaredField(pd1.getDisplayName()).getAnnotation(PropertyIndex.class);
                PropertyIndex index2 = clz.getDeclaredField(pd2.getDisplayName()).getAnnotation(PropertyIndex.class);
                return index1.value() > index2.value() ? 1 : -1;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            return 0;
        }).collect(toList());
        for (PropertyDescriptor pd : collect) {
            System.out.println(pd.getDisplayName());
        }
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Pojo{
    @PropertyIndex(1)
    private String d;
    @PropertyIndex(2)
    private String c;
    @PropertyIndex(3)
    private String b;
    @PropertyIndex(4)
    private String a;
}


