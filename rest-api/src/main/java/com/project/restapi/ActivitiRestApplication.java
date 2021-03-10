package com.project.restapi;

import com.project.restapi.bpmn.DeploymentFile;
import lombok.AllArgsConstructor;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@AllArgsConstructor
public class ActivitiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiRestApplication.class, args);
    }
}
