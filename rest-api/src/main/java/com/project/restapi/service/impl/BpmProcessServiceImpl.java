package com.project.restapi.service.impl;

import org.activiti.engine.RuntimeService;
import org.springframework.stereotype.Service;

import com.project.restapi.service.BpmProcessService;

@Service
public class BpmProcessServiceImpl implements BpmProcessService {

	private final RuntimeService runtimeService;

	public BpmProcessServiceImpl(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	@Override
	public String startProcessWithXml(String bpmXml) {
		return null;
	}

}
