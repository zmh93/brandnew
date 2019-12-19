import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * <a href="https://blog.csdn.net/gyshun/article/details/81000997"/>
 * @date 2019/12/18
 */
public class SampleClass {
    public String test() {
        return this.getClass().getName() + "test";
    }

    public String intro() {
        return this.getClass().getName() + "`s introduction";
    }

    public void fixedValueTest() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new FixedValue() {
            public Object loadObject() throws Exception {
                return "yo yo yo ,hello world";
            }
        });
        SampleClass sampleClass = (SampleClass)enhancer.create();
        System.out.println(sampleClass.intro());;
    }

    public void methodInterceptorTest() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println(method.getName() + "前切面");
                Object invoke = methodProxy.invokeSuper(o, args);
                System.out.println(method.getName() + "后切面");
                return invoke;
            }
        });
        SampleClass sampleClass = (SampleClass)enhancer.create();
        System.out.println(sampleClass.test());
    }

}
