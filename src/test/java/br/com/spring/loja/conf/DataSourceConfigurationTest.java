package br.com.spring.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class DataSourceConfigurationTest {

    @Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/springmvc_test");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("teste");
        dataSource.setPassword("123456");

        return dataSource;
    }
}
