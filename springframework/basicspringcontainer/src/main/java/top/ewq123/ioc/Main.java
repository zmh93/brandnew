package top.ewq123.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: top.ewq123.ioc.Main
 * Description: 创建一个简单的spring容器
 *
 * @author zhaomenghui93@163.com
 * @createDate 2019/7/18
 */
public class Main {
    public static void main(String[] args) {
        xmlContextStart();
    }

    private static void xmlContextStart() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-basic.xml");
        Object             testService = context.getBean("testService");
        if (testService instanceof TestService) {
            ((TestService) testService).intro();
        } else if (testService instanceof List) {
            System.out.println(testService);
        } else {
            System.out.println("未能获取testService");
        }
        //利用最主要的 beanFactory,在启动后操作bean
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
        TestService                testService2       = context.getBean(TestService.class);
        testService2.intro();
        System.out.println(testService == testService2);
        InjectWhenRunningService   bean        = beanFactory.getBean(InjectWhenRunningService.class);
        System.out.println(testService2.injectWhenRunningService == bean);
        bean.intro();
        context.close();
    }
}
