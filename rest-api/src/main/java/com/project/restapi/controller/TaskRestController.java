package com.project.restapi.controller;

import com.project.restapi.dto.TaskResultDto;
import lombok.AllArgsConstructor;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public TaskResultDto unClaimTask(@PathVariable String taskId) {
        if (taskId != null) {
            taskService.unclaim(taskId);
            Task task = taskService.createTaskQuery().taskId(taskId).list().get(0);
            return new TaskResultDto(taskId, task.getName(), task.getOwner(), task.getAssignee(), task.getProcessVariables());
        } else return null;
    }


    @GetMapping(value = "/group")
    @ResponseBody
    public List<Task> getGroupTasks(@RequestParam String id) {
        if (id != null) return taskService.createTaskQuery().taskCandidateGroup(id).active().list();
        else return null;
    }

    @GetMapping(value = "/user")
    @ResponseBody
    public List<Task> getUserTasks(@RequestParam String id) {
        if (id != null) return taskService.createTaskQuery().taskCandidateUser(id).active().list();
        else return null;
    }


}
