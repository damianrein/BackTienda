package com.BackTienda.entities;

import java.time.LocalDate;

import com.BackTienda.enums.Valoration;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private LocalDate date;
	@NotBlank
	private CustomUser user;
	@NotBlank
	private Long productId;
	@NotBlank
	private String message;
	@NotBlank
	@Enumerated(EnumType.ORDINAL)
	private Valoration valoration;
	
	public Comment() {}
	
	public Comment(Long id, LocalDate date, CustomUser user, Long productId, String message, Valoration valoration) {
		this.id = id;
		this.date = date;
		this.user = user;
		this.productId = productId;
		this.message = message;
		this.valoration = valoration;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public CustomUser getUser() {
		return user;
	}
	
	public Long getProductId() {
		return productId;
	}

	public String getMessage() {
		return message;
	}

	public Valoration getValoration() {
		return valoration;
	}
	
	
}
