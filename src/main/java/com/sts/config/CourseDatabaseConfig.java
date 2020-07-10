package com.sts.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		basePackages = {CourseDatabaseConfig.COURSE_REPOSITORY_PACKAGE},
		entityManagerFactoryRef = "courseEntityManagerFactory",
		transactionManagerRef = "courseTranscationManager")
public class CourseDatabaseConfig {
	public static final String COURSE_REPOSITORY_PACKAGE="com.sts.course.repository";
	public static final String COURSE_ENTITY_PACKAGE="com.sts.course.entity";
	
	
	@Bean
	@ConfigurationProperties(prefix = "spring.course.datasource")
	public DataSourceProperties courseDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	public DataSource courseDataSource(@Qualifier("courseDataSourceProperties") DataSourceProperties courseDataSourceProperties) {
		return courseDataSourceProperties.initializeDataSourceBuilder().build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean courseEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("courseDataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setPackagesToScan(COURSE_ENTITY_PACKAGE);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", MySQL8Dialect.class.getName());
		properties.put("hibernate.physical_naming_strategy",SpringPhysicalNamingStrategy.class.getName());
		properties.put("hibernate.implicit_naming_strategy",SpringImplicitNamingStrategy.class.getName());
		entityManagerFactoryBean.setJpaPropertyMap(properties);
		return entityManagerFactoryBean;
	}
	
	@Bean
	public PlatformTransactionManager courseTranscationManager(@Qualifier("courseEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
