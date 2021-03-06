package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.MonConverter;
import com.laptrinhjavaweb.dto.MonDTO;
import com.laptrinhjavaweb.entity.MonEntity;
import com.laptrinhjavaweb.repository.MonRepository;
import com.laptrinhjavaweb.service.IMonService;
@Service
public class MonService implements IMonService {
	@Autowired
	private MonRepository monRepository;
	@Autowired 
	private MonConverter monConverter;
	@Override
	public List<MonDTO> findAll(Pageable pageable) {
		List<MonDTO> models = new ArrayList<>();
		List<MonEntity> entities = monRepository.findAll(pageable).getContent();
		for (MonEntity item : entities) {
			MonDTO Model = monConverter.toDTO(item);
			models.add(Model);
		}
		return models;
	}
	@Override
	public int getTotalItem() {
		return (int) monRepository.count();
	}
	@Override
	public List<MonDTO> findAllByPhanLoai(String phanLoai, Pageable pageable) {	
		List<MonDTO> models = new ArrayList<>();
		List<MonEntity> entities = monRepository.findAllByPhanLoai(phanLoai, pageable);
		for (MonEntity item : entities) {
			MonDTO newModel = monConverter.toDTO(item);
			models.add(newModel);
		}
		return models;
	}
	@Override
	public int countByPhanLoai(String phanloai) {
		
		return (int) monRepository.countByPhanLoai(phanloai);
	}
	@Override
	public MonDTO findOneById(long id) {
		MonEntity entity = monRepository.findOne(id);
		return monConverter.toDTO(entity);
	}
	@Override
	public MonDTO save(MonDTO dto) {
		MonEntity monEntity = new MonEntity();
		if(dto.getId()!= null)
		{ 
			MonEntity oldmon = monRepository.findOne(dto.getId());
			monEntity = monConverter.toEntity(oldmon,dto);
		}
		else
		{ 
			monEntity = monConverter.toEntity(dto);
			
		}
		return monConverter.toDTO(monRepository.save(monEntity));
	}
	@Override
	public void delete(long[] ids) {
		for(long id: ids)
		{
			monRepository.delete(id);
		}	
	}
	
}
