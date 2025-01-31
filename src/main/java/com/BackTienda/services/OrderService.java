package com.BackTienda.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BackTienda.dtos.OrderRequest;
import com.BackTienda.entities.Order;
import com.BackTienda.repositories.ICustomUserRepository;
import com.BackTienda.repositories.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository repo;
	private final ICustomUserRepository userRepo;
	private final ProductService productService;
	
	public OrderService(@Autowired OrderRepository repo,@Autowired ICustomUserRepository userRepo,@Autowired ProductService productService) {
		this.repo = repo;
		this.userRepo = userRepo;
		this.productService = productService;
	}

	@Transactional
	public void createOrder(OrderRequest request) {
		BigDecimal total = request.items().stream().map(i->priceForItems(i.getProduct().getPrice(),i.getQuantity())).reduce(BigDecimal.ZERO, BigDecimal::add);
		Order order = new Order(userRepo.findById(request.userId()).get(),request.items(),total);
		repo.save(order);
		productService.discountStockForOrder(request.items());
	}
	
	//Devuelve el resultado de multiplicar el precio unitario por la cantidad
	private BigDecimal priceForItems(BigDecimal price, Short quality) {
		BigDecimal total = BigDecimal.ZERO;
		BigDecimal q = new BigDecimal(quality);
		total = (price.multiply(q));
		return total;
	}
	
	
}
