package top.ewq123.bootstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootstudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstudyApplication.class, args);
    }

    @Autowired
    TestMapper testMapper;

    @GetMapping("index")
    public Object index() {
        return testMapper.getBaseInfor();
    }
}
