package com.project.restapi.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.stereotype.Service;

import com.project.restapi.deployments.DeploymentBpmnFile;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeploymentFileService {

	private final SpringProcessEngineConfiguration springProcessEngineConfiguration;

	@Transactional
	public void deployProcess() throws IOException {
		springProcessEngineConfiguration.setDeploymentResources(DeploymentBpmnFile.getBpmnFiles());
	}

}
