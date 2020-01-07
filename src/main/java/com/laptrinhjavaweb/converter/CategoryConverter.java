package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;

public class CategoryConverter {
	public CategoryDTO toDTO(CategoryEntity entity)
	{
		CategoryDTO result = new CategoryDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setCode(entity.getCode());
		return result;
	}
	public CategoryEntity toEntity(CategoryDTO dto)
	{
		CategoryEntity result = new CategoryEntity();
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		return result;
	}
}
