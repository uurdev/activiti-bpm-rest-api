package com.project.restapi.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.restapi.deployments.DeploymentBpmnFile;
import com.project.restapi.service.ProcessService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class ProcessRestController {

	private final ProcessService processService;
	private final HistoryService historyService;
	private final RuntimeService runtimeService;
	private final RepositoryService repositoryService;

	@PostMapping(value = "/start/process")
	@ResponseBody
	public String startProcessInstance(@RequestParam String key) {
		return processService.startProcess(key);
	}

	@GetMapping(value = "/history/process")
	public List<HistoricProcessInstance> getInstanceHistory() {
		return historyService.createHistoricProcessInstanceQuery().list();
	}

	@GetMapping(value = "/process")
	public List<String> getInstance() {
		return runtimeService.createProcessInstanceQuery().list().stream().map(x -> x.getProcessInstanceId())
				.collect(Collectors.toList());
	}

	@PostMapping(value = "/deploy")
	public String deploy() throws IOException {
		System.err.println("-----------");
		return repositoryService.createDeployment()
				.addClasspathResource(DeploymentBpmnFile.BPMN_FILE_PATH + "timer-process.bpmn20.xml").deploy()
				.getKey();
	}

	@GetMapping(value = "/alive")
	public String alive() {
		return "Hey ! ";
	}
}
