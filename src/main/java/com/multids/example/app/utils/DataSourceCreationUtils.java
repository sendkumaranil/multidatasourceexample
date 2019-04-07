package com.multids.example.app.utils;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.multids.example.app.config.DataSourceProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceCreationUtils {

	public static HikariDataSource createMySqlDataSource(DataSourceProperties dataSourceProperties) {
		HikariConfig config = new HikariConfig();

		config.setDriverClassName(dataSourceProperties.getDriverClassName());
		config.setJdbcUrl(dataSourceProperties.getHost());
		config.setUsername(dataSourceProperties.getUsername());
		config.setPassword(dataSourceProperties.getPassword());
		return new HikariDataSource(config);
	}

	public static DataSource createH2DbDataSource(DataSourceProperties dataSourceProperties) {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUrl(dataSourceProperties.getHost());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
 
        return dataSource;
	}
}
