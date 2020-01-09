package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "idmon")
	private Long idMon;
	
	@Column(name = "soluong")
	private Integer soLuong;
	
	@Column(name = "thanhtien")
	private Integer thanhTien;

	/*
	 * @Column(name = "diachi") private String diaChi;
	 * 
	 * @Column(name = "sdt") private String sdt;
	 * 
	 * @Column(name = "ghichu") private String ghiChu;
	 * 
	 * @Column(name = "guiorder") private Integer guiOrder;
	 */
	public Long getId() {
		return id;
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



	/*
	 * public String getDiaChi() { return diaChi; }
	 * 
	 * 
	 * public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
	 * 
	 * 
	 * public String getSdt() { return sdt; }
	 * 
	 * public void setSdt(String sdt) { this.sdt = sdt; }
	 * 
	 * public String getGhiChu() { return ghiChu; }
	 * 
	 * public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
	 * 
	 * public Integer getGuiOrder() { return guiOrder; }
	 * 
	 * public void setGuiOrder(Integer guiOrder) { this.guiOrder = guiOrder; }
	 */
	
	
}
