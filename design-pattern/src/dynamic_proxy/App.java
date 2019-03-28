package dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * Title: App
 * Description:
 *
 * jdk默认只能基于接口实现动态代理,可以使用 cglib实现基于类继承的动态代理
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/3/28
 */
public class App {

    public static void main(String[] args) {
        ICup cup      = new Cup();
        //下面这句可以写在 InvocationHandler的实现类中,简化代码
        ICup cupProxy = (ICup) Proxy.newProxyInstance(ICup.class.getClassLoader(), cup.getClass().getInterfaces(), new CupProxy(cup));
        cupProxy.drink();
    }
}
