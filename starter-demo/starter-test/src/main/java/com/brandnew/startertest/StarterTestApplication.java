package com.brandnew.startertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 摘要
 * 本文主要介绍如何把一个Spring项目（特别是一些公共工具类项目），基于Spring Boot自动配置的思想封装起来，使其他Spring Boot项目引入后能够进行快速配置。
 *
 * AutoConfiguration
 * Spring Boot的一个重要特性就是提供了各种各样的AutoConfiguration。例如DataSourceAutoConfiguration。这样我们只需要在配置文件中进行如下配置：
 *
 * spring:
 *   datasource:
 *     url: jdbc:mysql://xxxxxxxxxxx/realname
 *     username: xxxxx
 *     password: xxxxx
 *     driverClassName: com.mysql.jdbc.Driver
 *
 * Spring Boot就会在容器中按照我们的配置的信息注入一个DataSource。那么Spring boot是怎么知道 DataSourceAutoConfiguration是自动配置类？其实很简单：
 *
 * Spring Boot在启动时候会读取文件Classpath:\META-INF\spring.factories的所有文件，spring.factories其实是一个properties的文件，即是 key = value的形式。
 *
 * 获取spring.factories中
 *
 * key=org.springframework.boot.autoconfigure.EnableAutoConfiguration配置项的值（类的全路径）作为Spring启动配置类
 *
 * Spring Boot 这种用“约定优于配置”思想可以大大的简化配置代码的编写。那么，我们就可以按照上面的套路来编写一个Spring Boot的自动配置类吧
 *
 * 实战
 * 现在有一个配置Bean——PrintAfterInitBean，需要Spring容器启动以后，打印一次消息，并且该消息的内容是在配置文件中定义
 *
 * 第一步，编写配置Bean——PrintAfterInitBean
 * 代码如下,因为只是一个简单例子，这里的配置Bean其实可以是其他任何复杂配置Bean，例如DataSource。往往一个公共包需要多个这样配置Bean才能完成其配置。
 *
 * public class PrintAfterInitBean implements InitializingBean {
 *     private String message;
 *
 *     public void afterPropertiesSet() throws Exception {
 *         System.out.println(message);
 *     }
 *     //setter getter
 * }
 *
 * 第二步，创建一个AutoConfiguration。
 *
 * 如果搜索Spring Boot下面的类，你会发现其实有很多名字形如xxxAutoConfiguration的类，这些类都是Spirng Boot为我们做的一些快捷配置类。 创建一个TestAutoConfig，作为一个自动配置类。
 *
 * @Configuration
 * public class TestAutoConfig {
 *
 *     @Bean
 *     @ConfigurationProperties(prefix = "init")
 *     @ConditionalOnMissingBean(PrintAfterInitBean.class)
 *     @ConditionalOnProperty(prefix = "init",value = "message")
 *     public PrintAfterInitBean printAfterInitBean() {
 *         return new PrintAfterInitBean();
 *     }
 * }
 *
 * @ConfigurationProperties 是Spring Boot提供的方便属性注入的注解，功能其实和@Value类似
 *
 * @ConditionalOnMissingBean 表示当BeanFactory中没有PrintAfterInitBean类型的Bean才会创建，否则就会忽略这个Bean。这个就是上图中所谓的【满足自动配置条件】，同理的，ConditionalOnProperty表示当存在配置前缀为init，配置值为message的配置的时候，才会生效。@ConditionalOnXXX 系列的注解都是为了在自动配置中，不侵入用户的配置。
 *
 * 第三步，创建spring.factories
 * 在resources下面创建META-INF/spring.factories, 然后在文件中把第二步的类配置进去：
 *
 * org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.xxx.TestAutoConfig
 * 这样就完成一个Spring Boot自动配置，如果存在init.message的配置，那么Spring Boot启动的时候就会打印init.message配置对应值。
 *
 * 小结
 * Spring Boot的自动配置为我们在编写一个重复的配置代码（或者xml文件）中提供一套简便的部署方式，这样当用其他spring boot的项目依赖我们jar时候，配置起来就十分方便拉。从代码可以看出，Spring Boot 其实并没有什么实质性的创新，只是把一些“约定”的配置信息转换原来通过代码或xml实现的配置。
 *
 * 常用注解
 * @ConditionalOnXXX
 * 前面已经介绍过，@ConditionalOnXXX 系列主要是自动配置是否生效，例如ConditionalOnClass，就是在某个Class存在的情况下才生效。这一系列的注解通过名字就知道用法，因此不再做过多的介绍。@ConditionalOnXXX 可以用于类名和方法名上。
 *
 * 用于类名上，要和 @Configuration一起使用，决定该配置类是否生效
 *
 * 用于方法名上（注：前提是该方法也是一个配置类，即有@Configuration注解），结合@Bean一起使用，判断该@Bean是否生成
 *
 * 用DataSourceAutoConfiguration 代码来说明。
 *
 * @Configuration
 * // 注：当存在DataSource.class 和 EmbeddedDatabaseType.class 存在的情况下，该配置路径才生效
 * @ConditionalOnClass({ DataSource.class, EmbeddedDatabaseType.class })
 * @EnableConfigurationProperties(DataSourceProperties.class)
 * @Import({ Registrar.class, DataSourcePoolMetadataProvidersConfiguration.class })
 * public class DataSourceAutoConfiguration {
 *
 *     private static final Log logger = LogFactory
 *             .getLog(DataSourceAutoConfiguration.class);
 *
 *     @Bean
 *          // 注：只有当BeanFactory中不存在DataSourceInitializer类的Bean的情况下才会有效
 *     @ConditionalOnMissingBean
 *     public DataSourceInitializer dataSourceInitializer(DataSourceProperties properties,
 *             ApplicationContext applicationContext) {
 *         return new DataSourceInitializer(properties, applicationContext);
 *     }
 * ...
 * }
 *
 * 自动配置的核心思想就是不侵占用户的代码，类似于“你有就用你的，你没有我就帮你做默认设置”。因此，我们在自己开发一个自动配置类的时候也需要注意这一点，不然就有点霸王条款的感觉。
 *
 * @EnableConfigurationProperties
 * 一般我们的自动配置类都会依赖外部的配置信息，而这些外部的配置信息可以封装成一个类，类似上面DataSourceAutoConfiguration中的@EnableConfigurationProperties(DataSourceProperties.class)，DataSourceProperties类就是用来保存DataSource相关的配置信息。“约定优于配置”的思想就在这里体现，如果配置信息是以spring.datasource为前缀，那么配置信息都会注入到DataSourceProperties类中，供DataSourceAutoConfiguration使用。
 *
 * @ConfigurationProperties(prefix = "spring.datasource")
 * public class DataSourceProperties
 *         implements BeanClassLoaderAware, EnvironmentAware, InitializingBean {
 *
 *         ...
 *     private Class<? extends DataSource> type;
 *     private String driverClassName;
 *     private String url;
 *     private String username;
 *     private String password;
 *         ...
 *
 * }
 *
 * @AutoConfigureAfter
 *
 * 在一些特殊的情况下，一些自动配置类需要在某一些其他配置类后进行，例如依赖另外一个自动配置的Bean，这个时候就@AutoConfigureAfter来进行约束。
 *
 * @Import
 * @Import也是比较常见的一个配置注解，主要用于引入其他配置类，但是另外一个比较有用的配置就是引入一个ImportBeanDefinitionRegistrar接口，而这个就是用于使用在ApplicationContext初始化阶段的时候，注册（register）一些BeanDefinition。当然常见的Bean是可以通过@Bean注解注入，但是一些Spring ApplicationContext启动过程中用的到一些Bean则不行，例如BeanPostProcessor，BeanFactoryPostProcessor。
 *
 * 总结
 * Spring Boot 核心思想就是“约定优于配置”思想，在创建一个微服务的时候有很多得天独厚的优势，往往只用短短几行配置，就可以部署一个应用。这样在编码更多的是一些业务层面。而如果我们自己编写的一个公共包也能够通过短短几行配置即可以完成，不仅仅是代码层面的减少，更是接入方来说是一种“一站式服务”体验。当然前提是接入方也是使用的Spring Boot。
 *
 * 觉得本文对你有帮助？请分享给更多人
 *
 */
@SpringBootApplication
public class StarterTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterTestApplication.class, args);
    }

}
