### jtaTest
1. tomcat默认不支持jta，需要引入 Jpa（atomikos）依赖。
2. 使用configurationProperties需要引入 springboot的相关依赖
3. 注意两个TestMybatisConfig中testDataSource@Bean注解的name要相同
4. [利用 JTA 处理事务](https://www.ibm.com/developerworks/cn/java/j-lo-jta/)

> 此处测试的是多数据源场景下使用 atomikos 进行事务管理,在分布式场景下,只需要在顶层调用的包配置好下层所有使用到的数据源，atomikos会自动进行回滚操作。
