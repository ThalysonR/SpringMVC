package br.com.spring.loja.conf;

import java.net.URISyntaxException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter(vendorAdapter);

		JPAProductionConfiguration prod = new JPAProductionConfiguration();

		DriverManagerDataSource dataSource = null;
		try {
			dataSource = prod.getDriverManagerDataSource();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		factoryBean.setDataSource(dataSource);

		Properties properties = prod.getProperties();
		
		factoryBean.setJpaProperties(properties);
		factoryBean.setPackagesToScan("br.com.spring.loja.models");
		
		return factoryBean;
	}

//	@Bean
//	@Profile("dev")
//	private Properties getProperties() {
//		Properties properties = new Properties();
//		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL92Dialect");
//		properties.setProperty("hibernate.show_sql", "true");
//		properties.setProperty("hibernate.hbm2ddl.auto", "update");
//		return properties;
//	}

//	@Bean
//	@Profile("dev")
//	private DriverManagerDataSource getDriverManagerDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.postgresql.Driver");
//
//		dataSource.setUsername("teste");
//		dataSource.setPassword("123456");
//		dataSource.setUrl("jdbc:postgresql://localhost/springmvc");
//		return dataSource;
//	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	
}
