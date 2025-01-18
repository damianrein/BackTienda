package com.BackTienda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackTienda.entities.Comment;
import com.BackTienda.services.CommentService;

@RestController
@RequestMapping("/c")
public class CommentController {

	@Autowired
	private CommentService service;

	public CommentController(@Autowired CommentService service) {
		this.service = service;
	}
	
	@PostMapping("/")
	public ResponseEntity<?> addNewComment(Comment c){
		service.addComment(c);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable Long id){
		service.deleteCommentById(id);
		return ResponseEntity.noContent().build();
	}
}
