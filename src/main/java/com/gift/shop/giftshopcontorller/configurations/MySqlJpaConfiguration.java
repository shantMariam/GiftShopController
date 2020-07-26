package com.gift.shop.giftshopcontorller.configurations;

import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class MySqlJpaConfiguration {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/gift_shop_sb?" +
                "createDatabaseIfNotExist=true&" +
                "useUnicode=true&" +
                "characterEncoding=UTF-8&" +
                "zeroDateTimeBehavior=CONVERT_TO_NULL&" +
                "serverTimezone=GMT&" +
                "useSSL=false");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean mb = new LocalContainerEntityManagerFactoryBean();
        mb.setDataSource(dataSource());
        mb.setPackagesToScan("com.gift.shop.giftshopcontorller");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        mb.setJpaVendorAdapter(vendorAdapter);
        mb.setJpaProperties(additionalProperties());
        return mb;
    }

    Properties additionalProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationAutoConfiguration exceptionTranslationAutoConfiguration() {
        return new PersistenceExceptionTranslationAutoConfiguration();
    }
}
