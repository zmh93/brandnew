package top.ewq123.ioc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

@Service
@Data
@Scope(SCOPE_SINGLETON)
public class TestService {

    @Autowired
    InjectWhenRunningService injectWhenRunningService;

    public void intro() {
        System.out.println("我是一个业务类!!!");
        injectWhenRunningService.intro();
    }
}
