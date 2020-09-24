package shophoaqua.entity;

import java.util.Set;

public class JSon_SanPham {
	private int maSanPham;
	DanhMucSanPham danhMucSanPham;
	private String tenSanPham;
	private String giatien;
	private String mota;
	private String hinhSanPham;
	private String gianhcho;
	private String luotmua;
	Set<ChiTietSanPham> chitienSanPham;
	Set<KhuyenMai> listKhuyenMai;
	
	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	public DanhMucSanPham getDanhMucSanPham() {
		return danhMucSanPham;
	}
	public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
		this.danhMucSanPham = danhMucSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getGiatien() {
		return giatien;
	}
	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getHinhSanPham() {
		return hinhSanPham;
	}
	public void setHinhSanPham(String hinhSanPham) {
		this.hinhSanPham = hinhSanPham;
	}
	public String getGianhcho() {
		return gianhcho;
	}
	public void setGianhcho(String gianhcho) {
		this.gianhcho = gianhcho;
	}
	public String getLuotmua() {
		return luotmua;
	}
	public void setLuotmua(String luotmua) {
		this.luotmua = luotmua;
	}
	public Set<ChiTietSanPham> getChitienSanPham() {
		return chitienSanPham;
	}
	public void setChitienSanPham(Set<ChiTietSanPham> chitienSanPham) {
		this.chitienSanPham = chitienSanPham;
	}
	public Set<KhuyenMai> getListKhuyenMai() {
		return listKhuyenMai;
	}
	public void setListKhuyenMai(Set<KhuyenMai> listKhuyenMai) {
		this.listKhuyenMai = listKhuyenMai;
	}
	
	
}
