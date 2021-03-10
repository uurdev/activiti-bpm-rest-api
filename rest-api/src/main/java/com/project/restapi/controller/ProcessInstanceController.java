package com.project.restapi.controller;

import com.project.restapi.dto.ProcessInstanceDto;
import lombok.AllArgsConstructor;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/process")
@AllArgsConstructor
public class ProcessInstanceController {

    private final RuntimeService runtimeService;


    @PostMapping(value = "/start/{defKey}/{variables}")
    public ProcessInstanceDto startProcessInstance(@PathVariable String defKey, @PathVariable Map<String, Object> variables) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(defKey, variables);
        if (processInstance != null) return new ProcessInstanceDto(processInstance, null);
        else return new ProcessInstanceDto(null, "Opss process not started");
    }

}
