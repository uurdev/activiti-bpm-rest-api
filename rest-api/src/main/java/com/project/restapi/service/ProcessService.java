package com.project.restapi.service;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProcessService {

    private final RuntimeService runtimeService;

    private final TaskService taskService;

    public ProcessService(RuntimeService runtimeService, TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }

    @Transactional
    public String startProcess(String processInstanceKey){
        return runtimeService.startProcessInstanceByKey(processInstanceKey).getProcessDefinitionKey();
    }

    public List<Task> getUserTasks(String ownerUserName){
        return taskService.createTaskQuery().taskAssignee(ownerUserName).list();
    }

    public void completeTask(String taskId){
        taskService.complete(taskId);
    }
}
