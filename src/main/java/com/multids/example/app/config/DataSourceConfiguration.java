package com.multids.example.app.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.mongodb.MongoClient;
import com.multids.example.app.utils.DataSourceCreationUtils;

@Configuration
public class DataSourceConfiguration {

	@Qualifier("mongodatasourceproperty")
	@Autowired
	private DataSourceProperties mongodataSourceProperties;
	
	@Bean("mysqlDS")
	public DataSource mysqlDataSource(@Qualifier("mysqldatasourceproperty") DataSourceProperties dataSourceProperties) {
		
		return DataSourceCreationUtils.createMySqlDataSource(dataSourceProperties);
	}
	
	@Bean("h2dbDS")
	public DataSource h2DbDataSource(@Qualifier("h2dbdatasourceproperty") DataSourceProperties dataSourceProperties) {
		
		return DataSourceCreationUtils.createH2DbDataSource(dataSourceProperties);
	}
	
	@Bean("mongoDS")
	public MongoDbFactory mongoDataSource() {
		
		return new SimpleMongoDbFactory(new MongoClient(mongodataSourceProperties.getHost(),mongodataSourceProperties.getPort()), "admin");
	}
	
	@Bean("sessionFactoryBean")
	public LocalSessionFactoryBean sessionFactory(@Qualifier("mysqlDS") final DataSource dataSource,HibernateProperties properties) {
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(
		        new String[] { "com.multids.example.app.entities" });
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.dialect", properties.getDialect());
		hibernateProperties.setProperty("hibernate.show_sql", properties.getShow_sql());
		
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
		
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(@Qualifier("sessionFactoryBean") SessionFactory sf) {
	    return new HibernateTransactionManager(sf);
	}
	
	@Bean("mongoTemplateBean")
	public MongoTemplate getMongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDataSource());
		return mongoTemplate;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(@Qualifier("h2dbDS") final DataSource dataSource) throws SQLException {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean("dataSourceMap")
	public Map<String,DataSource> dataSourceMap(@Qualifier("mysqlDS") DataSource mysqlDS,@Qualifier("h2dbDS") DataSource h2dbDS){
		Map<String,DataSource> dataSourcemap=new HashMap<>();
		dataSourcemap.put("mysqlDataSource", mysqlDS);
		dataSourcemap.put("h2dbDataSource", h2dbDS);
		
		return dataSourcemap;
	}
}
