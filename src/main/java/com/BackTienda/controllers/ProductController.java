package com.BackTienda.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackTienda.entities.Product;
import com.BackTienda.services.ProductService;

@RestController
@RequestMapping("/v1")
public class ProductController {

	private ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok(service.findAllProducts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable Long id){
		return ResponseEntity.ok(service.findProductById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id){
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/")
	public ResponseEntity<?> createProduct(@RequestBody Product p){
		service.newProduct(p);
		return ResponseEntity.accepted().build();
	}
}
