package com.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductClient productClient;
	
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
	public Order GeteOrderById(String id) {
		return orderRepository.findById(id).orElse(null);
	}
	
	public Order addOrder(Order order) {
		Product product = productClient.getProductById(order.getProductId());
		if(product != null) {
			return orderRepository.save(order);
		}else {
			throw new RuntimeException("Product not found");
		}
	}
}
