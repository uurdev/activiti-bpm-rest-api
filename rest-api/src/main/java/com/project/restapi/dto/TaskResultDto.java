package com.project.restapi.dto;

import lombok.*;

import java.util.Map;

@Data
public class TaskResultDto {

    private String taskId;

    private String taskName;

    private Map<String, Object> processVariables;

}
