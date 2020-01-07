package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.MonEntity;

public interface MonRepository extends JpaRepository<MonEntity, Long> {
	List<MonEntity> findAllByPhanLoai(String phanloai, Pageable pageable);
	int countByPhanLoai(String phanloai);
}
