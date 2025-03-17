package com.BackTienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BackTienda.entities.Comment;
import com.BackTienda.repositories.ICommentRepository;

@Service
public class CommentService {

	@Autowired
	private ICommentRepository repo;

	public CommentService(@Autowired ICommentRepository repo) {
		this.repo = repo;
	}
	
	public void addComment(Comment c) {
		repo.save(c);
	}
	
	public void deleteCommentById(Long id) {
		repo.deleteById(id);
	}
	
	public List<Comment> productComments(Long id){
		return repo.findByProductId(id);
	}
}
