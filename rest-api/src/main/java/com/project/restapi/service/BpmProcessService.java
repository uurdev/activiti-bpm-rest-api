package com.project.restapi.service;

import org.springframework.stereotype.Service;

@Service
public interface BpmProcessService {

	public String startProcessWithXml(String bpmXml);

}
