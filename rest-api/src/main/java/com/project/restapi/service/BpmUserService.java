package com.project.restapi.service;

import java.util.Optional;

import org.activiti.engine.identity.User;
import org.springframework.stereotype.Service;

@Service
public interface BpmUserService {

	public Optional<User> createUser(User user);

}
