package com.example.tkmbt.config;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@AutoConfigureAfter({MybatisAutoConfiguration.class})
@Configuration
public class TKConfig {


    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.example.tkmbt.mapper");
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        Properties properties = new Properties();
        properties.setProperty("ORDER","BEFORE");
        configurer.setProperties(properties);
        return configurer;
    }

}
