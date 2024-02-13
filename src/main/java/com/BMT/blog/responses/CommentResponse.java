package com.BMT.blog.responses;

import com.BMT.blog.entities.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
public class CommentResponse {
	
	@JsonProperty
	Long id;
	
	Long userId;
	String userName;
	String text;

	public CommentResponse(Comment entity) {
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
		this.userName = entity.getUser().getUserName();
		this.text = entity.getText();
	}
}