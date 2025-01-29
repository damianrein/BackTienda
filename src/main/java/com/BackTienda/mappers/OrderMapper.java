package com.BackTienda.mappers;

import java.util.List;

import com.BackTienda.entities.Cart;
import com.BackTienda.entities.CartItem;
import com.BackTienda.entities.Order;
import com.BackTienda.entities.OrderItem;

public class OrderMapper {

	public static OrderItem cartItemToOrderItem(CartItem cartItem) {
		OrderItem item = new OrderItem();
		item.setProduct(cartItem.getProduct());
		item.setQuantity(cartItem.getQuantity());
		return item;
	}
	
	public static List<OrderItem> cartItemToOrderItem(List<CartItem> cartItem) {
		List<OrderItem> item = cartItem.stream().map(i->cartItemToOrderItem(i)).toList();
		return item;
	}
	
	public static Order cartToOrder(Cart cart) {
		Order order = new Order(
				cart.getUser(),
				cartItemToOrderItem(cart.getProducts()),
				cart.getAmount());
		return order;
	}
}
