package com.project.restapi.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({ "taskId", "processId", "commentMessage" })
public class CommentDto {
	private String taskId;

	private String processId;

	private String commentMessage;
}
