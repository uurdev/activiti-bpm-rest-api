package com.project.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.activiti.engine.runtime.ProcessInstance;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProcessInstanceDto {

    private ProcessInstance processInstance;

    private String error;
}
