package com.project.restapi.controller;

import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Comment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.restapi.dto.CommentDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class CommentController {
	private final TaskService taskService;

	@PostMapping(value = "/comment")
	public Comment addComment(@RequestBody CommentDto commentDto) {
		return taskService.addComment(commentDto.getTaskId(), commentDto.getProcessId(),
				commentDto.getCommentMessage());
	}

	@GetMapping(value = "/comments")
	public List<Comment> getAllComments(@RequestParam String id) {
		return taskService.getProcessInstanceComments(id);
	}

	@DeleteMapping(value = "/comment")
	public void deleteComment(@RequestParam String id) {
		taskService.deleteComment(id);
	}

	@PostMapping(value = "/comment/test")
	public Comment addComment() {
		CommentDto dto = new CommentDto("2515", "2511", "Selam");
		return taskService.addComment(dto.getTaskId(), dto.getProcessId(), dto.getCommentMessage());
	}

}
