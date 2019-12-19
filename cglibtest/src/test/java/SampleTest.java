import java.lang.reflect.Method;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.beans.BulkBean;
import net.sf.cglib.beans.ImmutableBean;
import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SampleTest {
    @Test
    public void fixedValueTest() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new FixedValue() {
            public Object loadObject() throws Exception {
                return "yo yo yo ,hello world";
            }
        });
        SampleClass sampleClass = (SampleClass)enhancer.create();
        System.out.println(sampleClass.intro());
        ;
    }

    @Test
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

    @Test
    public void testInvocationHandler() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return "hello cglib";
                } else {
                    throw new RuntimeException("Do not know what to do");
                }
            }
        });
        SampleClass proxy = (SampleClass)enhancer.create();
        System.out.println(proxy.test());
        System.out.println(proxy.toString());
    }

    @Test
    public void testCallbackFilter() throws Exception {
        Enhancer enhancer = new Enhancer();
        CallbackHelper callbackHelper = new CallbackHelper(SampleClass.class, new Class[0]) {
            protected Object getCallback(Method method) {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return new FixedValue() {
                        public Object loadObject() throws Exception {
                            return "Hello cglib";
                        }
                    };
                } else {
                    return NoOp.INSTANCE;
                }
            }
        };
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        SampleClass proxy = (SampleClass)enhancer.create();
        assertEquals("Hello cglib", proxy.test());
        Assert.assertNotEquals("Hello cglib", proxy.toString());
        System.out.println(proxy.hashCode());
    }

    @Test
    public void immutableBeanTest() {
        SampleBean sampleBean = new SampleBean("origal bean");
        SampleBean immuBean = (SampleBean)ImmutableBean.create(sampleBean);
        System.out.println(immuBean.getValue());
        immuBean.setValue("immut bean");
        System.out.println(immuBean.getValue());
    }

    @Test
    public void testBeanGenerator() throws Exception {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("value", String.class);
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setValue", String.class);
        setter.invoke(myBean, "Hello cglib");

        Method getter = myBean.getClass().getMethod("getValue");
        assertEquals("Hello cglib", getter.invoke(myBean));
        System.out.println(myBean.getClass().getName());
    }

    @Test
    public void testBeanCopier() throws Exception {
        BeanCopier copier = BeanCopier.create(SampleBean.class, OtherSampleBean.class, false);//设置为true，则使用converter
        SampleBean myBean = new SampleBean();
        myBean.setValue("Hello cglib");
        OtherSampleBean otherBean = new OtherSampleBean();
        copier.copy(myBean, otherBean, null); //设置为true，则传入converter指明怎么进行转换
        assertEquals("Hello cglib", otherBean.getValue());
    }

    @Test
    public void testBulkBean() throws Exception {
        BulkBean bulkBean = BulkBean.create(SampleBean.class,
            new String[] {"getValue"},
            new String[] {"setValue"},
            new Class[] {String.class});
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");
        Object[] propertyValues = bulkBean.getPropertyValues(bean);
        assertEquals(1, bulkBean.getPropertyValues(bean).length);
        assertEquals("Hello world", bulkBean.getPropertyValues(bean)[0]);
        bulkBean.setPropertyValues(bean, new Object[] {"Hello cglib"});
        assertEquals("Hello cglib", bean.getValue());
    }

    @Test
    public void testBeanMap() throws Exception {
        BeanGenerator generator = new BeanGenerator();
        generator.addProperty("username", String.class);
        generator.addProperty("password", String.class);
        Object bean = generator.create();
        Method setUserName = bean.getClass().getMethod("setUsername", String.class);
        Method setPassword = bean.getClass().getMethod("setPassword", String.class);
        setUserName.invoke(bean, "admin");
        setPassword.invoke(bean, "password");
        BeanMap map = BeanMap.create(bean);
        Assert.assertEquals("admin", map.get("username"));
        Assert.assertEquals("password", map.get("password"));
    }
}
