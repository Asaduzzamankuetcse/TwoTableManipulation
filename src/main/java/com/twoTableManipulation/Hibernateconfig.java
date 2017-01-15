package com.twoTableManipulation;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration // this annotation is used to tell the spring configuration manager that this is a configuration class 
// in configuration class all the 'Bean' should define here
@EnableTransactionManagement // datasource need to set a transaction properties so that it can perform any batch execution in a safe way

public class Hibernateconfig {
	/***
	 * now we need to configure our data source which is a bean
	 * the data source is actually some configuration that it tells hibernate about the database
	 */
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/twotable");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	
	//Spring boot is supporting hibernate 5 and version 5 is compatible with mysql 4/5
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean(){
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.twoTableManipulation");
		
		Properties prop = new Properties();
		prop.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		prop.put("hibernate.hbm2ddl.auto", "update");
		prop.put("spring.jpa.show-sql", "true");
		
		sessionFactoryBean.setHibernateProperties(prop);
		
		
		return sessionFactoryBean;
	}
	
	
	
	//minimum configuration is ready but we need to configure transaction manager with hibernate
	public HibernateTransactionManager transactionManager(){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(localSessionFactoryBean().getObject());
		
		return transactionManager;
	}
	
	//this should work properly
}
