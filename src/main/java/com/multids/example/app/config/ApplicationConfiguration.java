package com.multids.example.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.validation.Validator;

import com.multids.example.app.validator.DataSourcePropertyValidator;

@Configuration
public class ApplicationConfiguration {

	@Bean("mysqldatasourceproperty")
	@ConfigurationProperties(prefix="mysql")
    public DataSourceProperties mysqlDataSourceProperties() {
    		return new DataSourceProperties();
    }
	
	@Bean("h2dbdatasourceproperty")
	@ConfigurationProperties(prefix="h2db")
    public DataSourceProperties h2DbDataSourceProperties() {
    		return new DataSourceProperties();
    }
	
	@Bean("mongodatasourceproperty")
	@ConfigurationProperties(prefix="mongo")
    public DataSourceProperties mongoDataSourceProperties() {
    		return new DataSourceProperties();
    }
	
	@Bean
	public static Validator configurationPropertiesValidator() {
		return new DataSourcePropertyValidator();
	}
	
}
