package com.project.restapi.dto;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TaskResultDto {

    private String taskId;

    private String taskName;

    private String taskOwnerName;

    private String taskAssignee;

    private Map<String, Object> processVariables;

}
