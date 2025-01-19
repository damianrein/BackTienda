package com.BackTienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackTienda.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findByUserIdOrderByOrderDateDesc(Long userId);
}
