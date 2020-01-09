package com.laptrinhjavaweb.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.service.IOrderService;
@RestController(value = "OrderAPIOfWeb")
public class OrderAPI {
	
	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/api/order")
	public OrderDTO createOrder(@RequestBody OrderDTO OrderDTO) {
		return orderService.save(OrderDTO);
	}
	
	@PutMapping("/api/order")
	public OrderDTO updateOrder(@RequestBody OrderDTO update) {
		return orderService.save(update);
	}
	
	@DeleteMapping("/api/order")
	public void deleteOrder(@RequestBody long[] ids) {
		orderService.delete(ids);
	}
}
