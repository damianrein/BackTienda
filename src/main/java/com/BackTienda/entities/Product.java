package com.BackTienda.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	private String description;
	@NotBlank
	@Min(value = 0, message = "Price cannot be less than zero")
	private BigDecimal price;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Comment> comment;
	private String urlPhoto;
	@Min(value = 0, message = "Stock cannot be less than zero")
	private Short stock;
	@NotBlank
	private Boolean enable;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public List<Comment> getComments() {
		return comment;
	}
	public void setComments(List<Comment> comment) {
		this.comment = comment;
	}
	public void addCommnt(Comment comment) {
		this.comment.add(comment);
	}
	public String getUrlPhoto() {
		return urlPhoto;
	}
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	public Long getId() {
		return id;
	}
	public Short getStock() {
		return stock;
	}
	public void setStock(Short stock) {
		this.stock = stock;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
}
