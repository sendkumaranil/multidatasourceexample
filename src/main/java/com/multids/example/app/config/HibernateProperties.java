package com.multids.example.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="hibernate")
public class HibernateProperties {

	private String dialect;
	private String show_sql;
	public String getDialect() {
		return dialect;
	}
	public void setDialect(String dialect) {
		this.dialect = dialect;
	}
	public String getShow_sql() {
		return show_sql;
	}
	public void setShow_sql(String show_sql) {
		this.show_sql = show_sql;
	}
}
