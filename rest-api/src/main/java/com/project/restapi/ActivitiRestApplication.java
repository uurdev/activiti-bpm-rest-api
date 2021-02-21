package com.project.restapi;

import com.project.restapi.bpmn.DeploymentFile;
import lombok.AllArgsConstructor;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
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
    }


    private void createUserAndGroup() {
        User user = identityService.newUser("user");

        User admin = identityService.newUser("admin");

        identityService.saveUser(user);

        identityService.saveUser(admin);

        Group userGroup = identityService.newGroup("user");

        Group adminGroup = identityService.newGroup("admin");

        identityService.saveGroup(userGroup);

        identityService.saveGroup(adminGroup);

        identityService.createMembership(user.getId(), userGroup.getId());

        identityService.createMembership(admin.getId(), adminGroup.getId());


    }
}
