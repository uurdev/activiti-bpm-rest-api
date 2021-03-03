package com.project.restapi;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.RestApiAutoConfiguration;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.project.restapi.bpmn.DeploymentFile;

import lombok.AllArgsConstructor;

@EnableAutoConfiguration(exclude = { RestApiAutoConfiguration.class, SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
@AllArgsConstructor
public class ActivitiRestApplication implements ApplicationRunner {

	private final SpringProcessEngineConfiguration springProcessEngineConfiguration;
	private final IdentityService identityService;

	public static void main(String[] args) {
		SpringApplication.run(ActivitiRestApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		springProcessEngineConfiguration.setDeploymentResources(DeploymentFile.getBpmnFiles());
		createUserAndGroup();
	}

	private void createUserAndGroup() {
		User user = identityService.newUser("user");
		user.setPassword("user");

		User admin = identityService.newUser("admin");
		admin.setPassword("admin");
		identityService.saveUser(user);

		identityService.saveUser(admin);

		Group userGroup = identityService.newGroup("user");

		Group adminGroup = identityService.newGroup("admin");

		identityService.saveGroup(userGroup);

		identityService.saveGroup(adminGroup);

		identityService.createMembership(user.getId(), userGroup.getId());

		identityService.createMembership(admin.getId(), adminGroup.getId());

		System.err.println("User account size : "
				+ identityService.createUserQuery().list().size());

	}
}
