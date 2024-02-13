package com.BMT.blog.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BMT.blog.entities.Comment;
import com.BMT.blog.requests.CommentCreateRequest;
import com.BMT.blog.requests.CommentUpdateRequest;
import com.BMT.blog.responses.CommentResponse;
import com.BMT.blog.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	private CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping
	public List<CommentResponse> getAllComments(@RequestParam Optional<Long> userId, 
			@RequestParam Optional<Long> postId) {
		return commentService.getAllCommentsWithParam(userId, postId);
	}
	
	@PostMapping
	public ResponseEntity<Comment> createOneComment(@RequestBody CommentCreateRequest request, Authentication auth) {
	    String username = auth.getName();
	    Comment createdComment = commentService.createOneComment(request);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
	}
	
	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable Long commentId) {
		return commentService.getOneCommentById(commentId);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest request) {
		return commentService.updateOneCommentById(commentId, request);
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteOneComment(@PathVariable Long commentId) {
		commentService.deleteOneCommentById(commentId);
	}
}