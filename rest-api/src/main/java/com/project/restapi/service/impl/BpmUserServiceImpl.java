package com.project.restapi.service.impl;

import java.util.Optional;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.springframework.stereotype.Service;

import com.project.restapi.service.BpmUserService;

@Service
public class BpmUserServiceImpl implements BpmUserService {

	private final IdentityService identityService;

	public BpmUserServiceImpl(IdentityService identityService) {
		this.identityService = identityService;
	}

	@Override
	public Optional<User> createUser(User user) {
		identityService.saveUser(user);
		return Optional.ofNullable(identityService.createUserQuery().userId(user.getId()).singleResult());
	}

}
