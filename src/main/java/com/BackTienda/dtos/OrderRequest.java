package com.BackTienda.dtos;

import java.util.List;

import com.BackTienda.entities.OrderItem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record OrderRequest(
		@NotBlank(message = "User ID cannot be null or blank") Long userId,
		@NotEmpty(message = "The items list cannot be empty") List<@NotBlank(message = "OrderItem cannot be null or blank") OrderItem> items) {

}
