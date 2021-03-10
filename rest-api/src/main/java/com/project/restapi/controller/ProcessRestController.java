package com.project.restapi.controller;

import com.project.restapi.dto.TaskResultDto;
import com.project.restapi.service.ProcessService;
import lombok.AllArgsConstructor;
import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class ProcessRestController {

    private final ProcessService processService;

    @PostMapping(value = "/start/process")
    @ResponseBody
    public String startProcessInstance(@RequestParam String key) {
        return processService.startProcess(key);
    }

    @PostMapping(value = "/task")
    @ResponseBody
    public void completeTask(@RequestParam String id) {
        processService.completeTask(id);
    }

    @GetMapping(value = "/task/{uid}/list")
    public List<TaskResultDto> getUserTasks(@PathVariable String uid) {
        List<Task> tasks = processService.getUserTasks(uid);
        List<TaskResultDto> taskResultDtos = new ArrayList<TaskResultDto>();
        for (Task task : tasks) {
            taskResultDtos.add(new TaskResultDto(task.getId(), task.getName(),task.getOwner(),task.getAssignee(), task.getProcessVariables()));
        }
        return taskResultDtos;
    }

    @GetMapping(value = "/alive")
    public String alive(){
        return "Hey ! ";
    }
}
