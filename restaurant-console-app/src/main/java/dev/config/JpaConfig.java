package dev.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Profile("jpaconf")
public class JpaConfig {
	@Bean
	public LocalContainerEntityManagerFactoryBean enityManagerFactory(DataSource dataSource) {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		
		LocalContainerEntityManagerFactoryBean managerFactory = new LocalContainerEntityManagerFactoryBean();
		
		managerFactory.setJpaVendorAdapter(vendorAdapter);
		managerFactory.setPackagesToScan("dev.entite");
		managerFactory.setDataSource(dataSource);
		managerFactory.afterPropertiesSet();
		
		return managerFactory;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManger = new JpaTransactionManager();
		transactionManger.setEntityManagerFactory(emf);
		
		return transactionManger;
	}
	
}
