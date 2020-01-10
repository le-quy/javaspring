package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.OrderConverter;
import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.entity.OrderEntity;
import com.laptrinhjavaweb.repository.OrderRepository;
import com.laptrinhjavaweb.service.IOrderService;
@Service
public class OrderService implements IOrderService {
	@Autowired
	private OrderRepository OrderRepository;
	@Autowired
	private OrderConverter OrderConverter;

		@Override
		public List<OrderDTO> findAll(Pageable pageable) {
			List<OrderDTO> models = new ArrayList<>();
			List<OrderEntity> entities = OrderRepository.findAll(pageable).getContent();
			for (OrderEntity item : entities) {
				OrderDTO newModel = OrderConverter.toDTO(item);
				models.add(newModel);
			}
			return models;
		}


		@Override
		public OrderDTO save(OrderDTO dto) {
			OrderEntity entity = new OrderEntity();
			/*if(dto.getId()!= null)
			{ 
				NewEntity oldnew = OrderRepository.findOne(dto.getId());
				oldnew.setCategory(category);
				newEntity = newConverter.toEntity(oldnew,dto);
			}*/ 
				entity = OrderConverter.toEntity(dto);			
			return OrderConverter.toDTO(OrderRepository.save(entity));
		}
		

		@Override
		public void delete(long[] ids) {	
			for(long id: ids)
			{
			OrderRepository.delete(id);
			}
		}


		@Override
		public List<OrderEntity> findByUserNameAndGuiOrder(String userName, int guiOrder) {
			// TODO Auto-generated method stub
			return null;
		}

}
