import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: Main
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
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-basic.xml");
        TestService bean               = context.getBean(TestService.class);
        bean.intro();
    }
}
