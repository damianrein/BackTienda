package com.BackTienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackTienda.entities.Comment;

public interface ICommentRepository extends JpaRepository<Comment, Long>{

}
