package com.BackTienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackTienda.entities.Comment;

public interface ICommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findByProductId(Long productId);
}
