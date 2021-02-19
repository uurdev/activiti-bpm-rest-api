package com.project.restapi.controller;

import com.project.restapi.dto.TaskResultDto;
import lombok.AllArgsConstructor;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/task")
@AllArgsConstructor
public class TaskRestController {

    private final TaskService taskService;

    @PostMapping(value = "/claim")
    public TaskResultDto claimTask(@PathVariable String taskId, @PathVariable String userId) {
        if (taskId != null && userId != null) {
            taskService.claim(taskId, userId);
            Task task = taskService.createTaskQuery().taskId(taskId).list().get(0);
            return new TaskResultDto(taskId, task.getName(), task.getOwner(), task.getAssignee(), task.getProcessVariables());
        } else return null;
    }

    @PostMapping(value = "/unclaim")
    public TaskResultDto unclaim(@PathVariable String taskId) {
        if (taskId != null) {
            taskService.unclaim(taskId);
            Task task = taskService.createTaskQuery().taskId(taskId).list().get(0);
            return new TaskResultDto(taskId, task.getName(), task.getOwner(), task.getAssignee(), task.getProcessVariables());
        } else return null;
    }


}
