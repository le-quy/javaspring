package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.entity.OrderEntity;

public interface IOrderService {
	List<OrderDTO> findAll(Pageable pageable);
	List<OrderEntity> findByUserNameAndGuiOrder(String userName, int guiOrder); 
	OrderDTO save(OrderDTO dto);
	void delete(long[] id);
}
