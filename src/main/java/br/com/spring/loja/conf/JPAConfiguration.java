package br.com.spring.loja.conf;


import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@EnableTransactionManagement
public class JPAConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("teste");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/springmvc");
        dataSource.setDriverClassName("org.postgresql.Driver");
        factoryBean.setDataSource(dataSource);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        factoryBean.setJpaProperties(properties);

        factoryBean.setPackagesToScan("br.com.spring.loja.models");

        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionalManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}
