package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.MonDTO;
import com.laptrinhjavaweb.entity.MonEntity;
@Component
public class MonConverter {
	public MonDTO toDTO(MonEntity entity)
	{ 
		MonDTO result = new MonDTO();
		result.setId(entity.getId());
		result.setTenMon(entity.getTenMon());
		result.setDonGia(entity.getDonGia());	
		result.setHinhAnh(entity.getHinhAnh());
		result.setPhanLoai(entity.getPhanLoai());
		return result;
	}
	public MonEntity toEntity(MonDTO dto)
	{ 
		MonEntity result = new MonEntity();
		result.setTenMon(dto.getTenMon());
		result.setDonGia(dto.getDonGia());
		result.setHinhAnh(dto.getHinhAnh());
		result.setPhanLoai(dto.getPhanLoai());
		return result;
	}
	public MonEntity toEntity(MonEntity result, MonDTO dto)
	{ 
		result.setTenMon(dto.getTenMon());
		result.setDonGia(dto.getDonGia());
		result.setHinhAnh(dto.getHinhAnh());
		result.setPhanLoai(dto.getPhanLoai());
		return result;
	}
}
