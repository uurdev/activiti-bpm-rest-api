package com.project.restapi.controller;

import org.activiti.engine.task.Comment;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.project.restapi.dto.CommentDto;

@ExtendWith(MockitoExtension.class)
public class CommentControllerTest {
	@InjectMocks
	CommentController commentController;

	@Test
	public void testAddEmployee() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		CommentDto commentDto = new CommentDto("2508", "2504", "Selam");
		Comment responseEntity = commentController.addComment(commentDto);
		if (responseEntity != null) {
			System.err.println("Success");
		}
	}
}
