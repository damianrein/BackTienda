package com.BackTienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BackTienda.entities.OrderItem;
import com.BackTienda.entities.Product;
import com.BackTienda.repositories.IProductRepository;


@Service
public class ProductService {

	private final IProductRepository repo;

	public ProductService(@Autowired IProductRepository repo) {
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
	
	@Transactional
    public synchronized void discountStock(Long productId, Short quantity) {
        // Buscar el producto por ID
        Product product = repo.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        // Verificar que haya suficiente stock
        if (product.getStock() < quantity) {
            throw new IllegalArgumentException("Not enough stock available");
        }

        // Descontar el stock
        product.setStock((short) (product.getStock() - quantity));

        // Guardar los cambios
        repo.save(product);
    }
	
    @Transactional
    public void discountStockForOrder(List<OrderItem> orderItems) {
        // Verificar si todos los productos tienen suficiente stock
        for (OrderItem item : orderItems) {
            Product product = repo.findById(item.getId())
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + item.getId()));

            if (product.getStock() < item.getQuantity()) {
                throw new IllegalArgumentException(
                    "Insufficient stock for product: " + product.getName() + " (ID: " + product.getId() + ")"
                );
            }
        }

        // Si todo está bien, descontar el stock
        for (OrderItem item : orderItems) {
            Product product = repo.findById(item.getId()).get(); // Ya validado antes
            product.setStock((short) (product.getStock() - item.getQuantity()));
            repo.save(product);
        }
    }
}
