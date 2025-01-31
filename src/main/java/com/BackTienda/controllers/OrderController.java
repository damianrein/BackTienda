package com.BackTienda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackTienda.dtos.OrderRequest;
import com.BackTienda.services.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
@Validated
public class OrderController {

	private final OrderService service;
	
	public OrderController(@Autowired OrderService service) {
		this.service = service;
	}

	@PostMapping("/")
	public ResponseEntity<?> newOrder(@Valid @RequestBody OrderRequest order){
		service.createOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
