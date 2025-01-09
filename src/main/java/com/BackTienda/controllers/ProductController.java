package com.BackTienda.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackTienda.services.ProductService;

@RestController
@RequestMapping("/v1")
public class ProductController {

	private ProductService service;
}
