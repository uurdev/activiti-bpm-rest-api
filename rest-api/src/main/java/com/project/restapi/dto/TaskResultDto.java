package com.project.restapi.dto;

import java.util.Map;

public class TaskResultDto {

    private String taskId;

    private String taskName;

    private Map<String, Object> processVariables;

    public TaskResultDto(String taskId, String taskName, Map<String, Object> processVariables) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.processVariables = processVariables;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Map<String, Object> getProcessVariables() {
        return processVariables;
    }

    public void setProcessVariables(Map<String, Object> processVariables) {
        this.processVariables = processVariables;
    }
}
