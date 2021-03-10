package com.project.restapi.configuration;

import javax.sql.DataSource;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan
public class ActivitiBpmEngineConfiguration {

	@Bean
	public DataSource postgresDatabaseConnection() {
		return DataSourceBuilder.create().url("jdbc:postgresql://localhost:5432/activitirest").username("postgres").password("postgres").driverClassName("org.postgresql.Driver").build();
	}

	@Bean
	DataSource h2DatabaseConnection() {
		return DataSourceBuilder.create().url("jdbc:h2:mem:activitirest").username("sa").password("password").driverClassName("org.h2.Driver").build();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(h2DatabaseConnection());
	}

	@Bean
	public ProcessEngineFactoryBean processEngine() {
		ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
		factoryBean.setProcessEngineConfiguration(processEngineConfiguration());
		return factoryBean;
	}

	@Bean
	public SpringProcessEngineConfiguration processEngineConfiguration() {
		SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();
		config.setDataSource(h2DatabaseConnection());
		config.setTransactionManager(transactionManager());
//		config.setDatabaseSchemaUpdate("update");
		config.setDatabaseSchemaUpdate("create-drop");
		config.setHistory("audit");
		config.setAsyncExecutorActivate(true);
		return config;
	}

	@Bean
	public RepositoryService repositoryService(ProcessEngine processEngine) {
		return processEngine.getRepositoryService();
	}

	@Bean
	public RuntimeService runtimeService(ProcessEngine processEngine) {
		return processEngine.getRuntimeService();
	}

	@Bean
	public TaskService taskService(ProcessEngine processEngine) {
		return processEngine.getTaskService();
	}

	@Bean
	public IdentityService identityService(ProcessEngine processEngine) {
		return processEngine.getIdentityService();
	}

	@Bean
	public ManagementService managementService(ProcessEngine processEngine) {
		return processEngine.getManagementService();
	}

}
