package com.BackTienda.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private CustomUser user;
	private List<OrderItem> items;
	private BigDecimal total;
	
	public Order() {}
	
	public Order(CustomUser user, List<OrderItem> items, BigDecimal total) {
		this.user = user;
		this.items = items;
		this.total = total;
	}

	public Order(Long id, CustomUser user, List<OrderItem> items, BigDecimal total) {
		this.id = id;
		this.user = user;
		this.items = items;
		this.total = total;
	}

	public CustomUser getUser() {
		return user;
	}
	public void setUser(CustomUser user) {
		this.user = user;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public void addItem(OrderItem item) {
		this.items.add(item);
	}
	public void removeItem(OrderItem item) {
		this.items.remove(item);
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Long getId() {
		return id;
	}
}
