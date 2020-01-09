package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.entity.OrderEntity;

@Component
public class OrderConverter {
	public OrderDTO toDTO(OrderEntity entity)
	{ 
		OrderDTO result = new OrderDTO();
		result.setId(entity.getId());
		result.setUserName(entity.getUserName());
		result.setIdMon(entity.getIdMon());
		result.setSoLuong(entity.getSoLuong());
		result.setThanhTien(entity.getThanhTien());
		/*
		 * result.setDiachi(entity.getDiaChi()); result.setSdt(entity.getSdt());
		 * result.setGhiChu(entity.getGhiChu());
		 * result.setGuiOrder(entity.getGuiOrder());
		 */
		return result;
	}
	public OrderEntity toEntity(OrderDTO dto)
	{ 
		OrderEntity result = new OrderEntity();
		result.setUserName(dto.getUserName());
		result.setIdMon(dto.getIdMon());
		result.setSoLuong(dto.getSoLuong());
		result.setThanhTien(dto.getThanhTien());
		/*
		 * result.setDiaChi(dto.getDiachi()); result.setSdt(dto.getSdt());
		 * result.setGhiChu(dto.getGhiChu()); result.setGuiOrder(dto.getGuiOrder());
		 */
		return result;
	}
}
