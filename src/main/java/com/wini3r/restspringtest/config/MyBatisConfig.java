package com.wini3r.restspringtest.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@MapperScan("com.wini3r.restspringtest.mapper")
@Configuration
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }

    @Bean
    public DataSource dataSource() {
        String resource = "database/jdbc.properties";
        try (InputStream inputStream = Resources.getResourceAsStream(resource);) {
            Properties properties = new Properties();
            properties.load(inputStream);
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(properties.getProperty("jdbc.driver"));
            dataSource.setUrl(properties.getProperty("jdbc.url"));
            dataSource.setUsername(properties.getProperty("jdbc.username"));
            dataSource.setPassword(properties.getProperty("jdbc.password"));
            dataSource.setInitialSize(5);
            return dataSource;
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка чтения конфига jdbc: " + resource, ex);
        }
    }

    /**
     * Создание мапера без анотации
     *
     * @MapperScan("org.mybatis.spring.sample.mapper")
     */
//    @Bean
//    public MapperFactoryBean<CarrierMapper> carrierMapper() throws Exception {
//        MapperFactoryBean<CarrierMapper> factoryBean = new MapperFactoryBean<>(CarrierMapper.class);
//        factoryBean.setSqlSessionFactory(sqlSessionFactory());
//        return factoryBean;
//    }
    /**
     * Для тестирования транзакции
     *
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource());
        return manager;
    }
}
