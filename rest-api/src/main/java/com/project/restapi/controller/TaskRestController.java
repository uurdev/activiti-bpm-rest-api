package com.project.restapi.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.restapi.dto.TaskResultDto;
import com.project.restapi.service.ProcessService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/task")
@AllArgsConstructor
public class TaskRestController {

	private final TaskService taskService;
	private final ProcessService processService;

	@PostMapping(value = "/claim")
	public TaskResultDto claimTask(@PathVariable String taskId, @PathVariable String userId) {
		if (taskId != null && userId != null) {
			taskService.claim(taskId, userId);
			Task task = taskService.createTaskQuery().taskId(taskId).list().get(0);
			return new TaskResultDto(taskId, task.getName(), task.getOwner(), task.getAssignee(),
					task.getProcessVariables());
		} else
			return null;
	}

	@PostMapping(value = "/complete")
	@ResponseBody
	public void completeTask(@RequestParam String id) {
		processService.completeTask(id);
	}

	@GetMapping(value = "/{uid}")
	public List<TaskResultDto> getUserTasks(@PathVariable String uid) {
		List<Task> tasks = processService.getUserTasks(uid);
		List<TaskResultDto> taskResultDtos = new ArrayList<TaskResultDto>();
		for (Task task : tasks) {
			taskResultDtos.add(new TaskResultDto(task.getId(), task.getName(), task.getOwner(), task.getAssignee(),
					task.getProcessVariables()));
		}
		return taskResultDtos;
	}

	@PostMapping(value = "/unclaim")
	public TaskResultDto unClaimTask(@PathVariable String taskId) {
		if (taskId != null) {
			taskService.unclaim(taskId);
			Task task = taskService.createTaskQuery().taskId(taskId).list().get(0);
			return new TaskResultDto(taskId, task.getName(), task.getOwner(), task.getAssignee(),
					task.getProcessVariables());
		} else
			return null;
	}

	@GetMapping(value = "/group")
	@ResponseBody
	public List<Task> getGroupTasks(@RequestParam String id) {
		if (id != null)
			return taskService.createTaskQuery().taskCandidateGroup(id).active().list();
		else
			return null;
	}

	@PostMapping(value = "/due")
	public Date setDueDate(@RequestParam String id) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 1);
		taskService.setDueDate(id, cal.getTime());
		return taskService.createTaskQuery().taskId(id).singleResult().getDueDate();
	}

}
