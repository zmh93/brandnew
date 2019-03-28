package dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CupProxy implements InvocationHandler {

    private Object obj;

    public CupProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object invoke = method.invoke(obj, args);
        System.out.println("after invoke");
        return invoke;
    }
}
