package com.BackTienda.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private CustomUser user;
	private List<CartItem> items;
	private BigDecimal amount;
	
	public List<CartItem> getProducts() {
		return items;
	}
	public void setProducts(List<CartItem> products) {
		this.items = products;
	}
	public void addProductToList(CartItem p) {
		this.items.add(p);
	}
	public void removeProductOfList(CartItem p) {
		this.items.remove(p);
	}
	public CustomUser getUser() {
		return user;
	}
	public void setUser(CustomUser user) {
		this.user = user;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Long getId() {
		return id;
	}
	
	
}
