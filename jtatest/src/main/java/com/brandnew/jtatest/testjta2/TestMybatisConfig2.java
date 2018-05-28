package com.brandnew.jtatest.testjta2;

import com.brandnew.jtatest.config.DBConfig2;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "com.brandnew.jpatest.testjta2", sqlSessionTemplateRef = "testSqlSessionTemplate")
public class TestMybatisConfig2 {

    // 配置数据源
    @Primary
    @Bean(name = "testDataSource")
    public DataSource testDataSource(DBConfig2 dbConfig2) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dbConfig2.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dbConfig2.getPassword());
        mysqlXaDataSource.setUser(dbConfig2.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("testDataSource");

        xaDataSource.setMinPoolSize(dbConfig2.getMinPoolSize());
        xaDataSource.setMaxPoolSize(dbConfig2.getMaxPoolSize());
        xaDataSource.setMaxLifetime(dbConfig2.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(dbConfig2.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(dbConfig2.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(dbConfig2.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(dbConfig2.getMaxIdleTime());
        xaDataSource.setTestQuery(dbConfig2.getTestQuery());
        return xaDataSource;
    }
    @Primary
    @Bean(name = "testSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Primary
    @Bean(name = "testSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public DBConfig2 deConfig2() {
        return new DBConfig2();
    }
}