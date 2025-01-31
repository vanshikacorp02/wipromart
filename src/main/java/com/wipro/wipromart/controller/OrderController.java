package com.wipro.wipromart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wipro.wipromart.entity.Customer;
import com.wipro.wipromart.entity.Order;
import com.wipro.wipromart.repository.CustomerRepository;
import com.wipro.wipromart.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
    private CustomerRepository customerRepository;

	@PostMapping("/save")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		
		// Fetch the customer by customerId from the order object
		Customer customer = customerRepository.findById(order.getCustomer().getCustomerId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer not found"));
		
		// Set the fetched customer to the order
		order.setCustomer(customer);
		
		// Save the order
		orderService.saveOrder(order);
		
		return new ResponseEntity<>(order, HttpStatus.CREATED);		
	}
	
	@GetMapping("/get/{orderId}")
	public ResponseEntity<Order> fetchOrder(@PathVariable int orderId) {
		
		Order order = orderService.getOrderDetails(orderId);
		
		return new ResponseEntity<>(order, HttpStatus.OK);
		
	}
}
