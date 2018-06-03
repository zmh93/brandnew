package com.brandnew.easydb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  使用内存数据库h2 + jpa 方便快速开发，但是项目的初始化数据还是需要从data.sql或者schema.sql读入
 * @createDate 2018/6/3
 */
@SpringBootApplication
public class EasydbApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasydbApplication.class, args);
    }
}
