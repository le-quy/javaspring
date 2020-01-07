package com.laptrinhjavaweb.dto;

public class Order {
	private Long id;
	private String userName;
	private Long idMon;
	private Integer giaTien;
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
	public Integer getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(Integer giaTien) {
		this.giaTien = giaTien;
	}
	
}
