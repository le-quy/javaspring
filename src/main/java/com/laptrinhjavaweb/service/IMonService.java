package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.MonDTO;
import com.laptrinhjavaweb.dto.NewDTO;

public interface IMonService {
	List<MonDTO> findAll(Pageable pageable);
	int getTotalItem();
	int countByPhanLoai(String phanloai);
	List<MonDTO> findAllByPhanLoai(String phanloai ,Pageable pageable);
	MonDTO findOneById(long id);
}
