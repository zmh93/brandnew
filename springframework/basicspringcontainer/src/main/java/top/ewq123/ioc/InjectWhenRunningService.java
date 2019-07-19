package top.ewq123.ioc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 *  运行时手动注入的bean
 *
 * @createDate 2019/7/19
 */
@Service
@Scope(SCOPE_PROTOTYPE)
public class InjectWhenRunningService {
    private static long count = 0;
    public void intro() {
        System.out.println("我是运行时注入的第"+ ++count +"个bean!");
    }
}
