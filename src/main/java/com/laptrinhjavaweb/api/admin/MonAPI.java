package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.MonDTO;
import com.laptrinhjavaweb.service.IMonService;

@RestController(value= "sanphamAPIOfAdmin")
public class MonAPI {
	@Autowired
	private IMonService monService;
	
	@PostMapping("/api/sanpham")
	public MonDTO createMon(@RequestBody MonDTO monDTO) {
		return monService.save(monDTO);
	}
	
	@PutMapping("/api/sanpham")
	public MonDTO updateMon(@RequestBody MonDTO update) {
		return monService.save(update);
	}
	
	@DeleteMapping("/api/sanpham")
	public void deleteMon(@RequestBody long[] ids) {
		monService.delete(ids);
	}
}
