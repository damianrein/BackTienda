package com.BackTienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackTienda.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {

	
}
