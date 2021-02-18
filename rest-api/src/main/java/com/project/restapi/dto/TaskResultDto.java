package com.project.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskResultDto {

    private String taskId;

    private String taskName;

    private Map<String, Object> processVariables;

}
