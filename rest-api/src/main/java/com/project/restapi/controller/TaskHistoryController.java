package com.project.restapi.controller;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/history")
@AllArgsConstructor
public class TaskHistoryController {

	private final HistoryService historyService;

	@GetMapping
	public List<HistoricTaskInstance> getProcessTaskDetails(@PathVariable String processId) {
		return historyService.createHistoricTaskInstanceQuery().processInstanceId(processId).list();
	}

}
