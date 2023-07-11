package com.javasm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * @Author zk
 * @Date 2023/7/10 15:15
 * @注释：配置类
 * @EnableAspectJAutoProxy 开启AOP的使用
 * @EnableTransactionManagement 开启事务管理
 */
@Configuration
@ComponentScan("com.javasm")
@MapperScan("com.javasm.mapper")
@PropertySource("classpath:db.properties")
@EnableWebMvc //相当于处理器映射器与处理器适配器的配置
public class SpringConfig {
    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${jdbcUserName}")
    private String jdbcUserName;
    @Value("${pwd}")
    private String pwd;

    /**
     * 数据源的配置
     *
     * @return
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(jdbcUserName);
        druidDataSource.setPassword(pwd);
        return druidDataSource;
    }

    /**
     * sqlSession  SqlSessionFactory
     * mybatis和spring的集成包 中提供的类型
     *
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        配置数据源
        sqlSessionFactoryBean.setDataSource(dataSource());
//        实体类的路径 user com.javasm.entity.User
        sqlSessionFactoryBean.setTypeAliasesPackage("com.javasm.entity");
//        开启驼峰标志
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean;
    }
}
