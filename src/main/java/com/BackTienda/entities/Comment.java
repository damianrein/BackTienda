package com.BackTienda.entities;

import java.time.LocalDate;

import com.BackTienda.enums.Valoration;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public class Comment {

	@NotBlank
	private LocalDate date;
	@NotBlank
	private CustomUser user;
	@NotBlank
	private String message;
	@NotBlank
	@Enumerated(EnumType.ORDINAL)
	private Valoration valoration;
	
	public Comment(LocalDate date, CustomUser user, String message, Valoration valoration) {
		this.date = date;
		this.user = user;
		this.message = message;
		this.valoration = valoration;
	}
	
	
}
