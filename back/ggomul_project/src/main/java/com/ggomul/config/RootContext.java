package com.ggomul.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.ggomul" })
public class RootContext {
	@Bean
	public BasicDataSource dataSource() { // DB 정보
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		datasource.setUsername("GGOMUL");
		datasource.setPassword("RhanfRhanf00");
		/*
		 * datasource.setUrl(
		 * "jdbc:oracle:thin:@ggomuldb_high?TNS_ADMIN=C:\\\\Users\\\\Shinwoo\\\\Documents\\\\ggomuldb\\\\DB\\\\Wallet"
		 * ); datasource.setUsername("admin"); datasource.setPassword("ggomulDB1234");
		 */

		return datasource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() { // jpa 설정
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPersistenceUnitName("jpa-sql"); // persistence.xml의 설정 정의된 이름
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		return entityManagerFactory;
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws Exception { // transaction 설정
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return jpaTransactionManager;
	}
}
