package com.laptrinhjavaweb.dto;

public class MonDTO extends AbstractDTO<MonDTO> {
	
	private String tenMon;
	private Integer donGia;
	private String phanLoai;
	private String hinhAnh;
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public Integer getDonGia() {
		return donGia;
	}
	public void setDonGia(Integer donGia) {
		this.donGia = donGia;
	}
	public String getPhanLoai() {
		return phanLoai;
	}
	public void setPhanLoai(String phanLoai) {
		this.phanLoai = phanLoai;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
}
