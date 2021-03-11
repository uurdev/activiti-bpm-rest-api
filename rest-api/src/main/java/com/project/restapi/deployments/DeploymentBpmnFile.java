package com.project.restapi.deployments;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class DeploymentBpmnFile {

	public static String BPMN_FILE_PATH = "processes/";

	public static Resource[] getBpmnFiles() throws IOException {
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		return resourcePatternResolver.getResources("classpath*:" + BPMN_FILE_PATH + "**/*.bpmn");
	}
}
