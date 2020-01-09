package com.laptrinhjavaweb.dto;

public class OrderDTO {
	private Long id;
	private String userName;
	private Long idMon;
	private Integer soLuong;
	private Integer thanhTien;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getIdMon() {
		return idMon;
	}
	public void setIdMon(Long idMon) {
		this.idMon = idMon;
	}
	public Integer getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}
	public Integer getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(Integer thanhTien) {
		this.thanhTien = thanhTien;
	}

	
}
