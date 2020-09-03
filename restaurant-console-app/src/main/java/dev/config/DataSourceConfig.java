package dev.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {
	@Bean
	public DataSource dataSource(@Value("${bdd.driver}")
								String driver,
								@Value("${bdd.url}")
								String url,
								@Value("${bdd.user}")
								String userName,
								@Value("${bdd.pass}")
								String password) {
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(userName);
			ds.setPassword(password);
			
			return ds;
	}
}
