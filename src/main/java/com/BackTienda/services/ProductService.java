package com.BackTienda.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BackTienda.entities.Product;
import com.BackTienda.repositories.IProductRepository;

@Service
public class ProductService {

	private IProductRepository repo;

	public ProductService(IProductRepository repo) {
		this.repo = repo;
	}
	
	public void deleteProductoById(Long id) {
		repo.deleteById(id);
	}
	
	public List<Product> findAllProducts(){
		return repo.findAll();
	}
	
	public Product findProductById(Long id) {
		return repo.findById(id).orElseThrow();
	}
	
	public void newProduct(Product p) {
		repo.save(p);
	}
}
