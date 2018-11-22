package com.brandnew.differdatasourceexplore;

import com.brandnew.differdatasourceexplore.mapepr.primary.PojoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DifferDatasourceExploreApplicationTests {

    @Autowired
    private PojoMapper pojoMapper;

    @Test
    public void contextLoads() {
        System.out.println(pojoMapper.findAll());
    }

}
