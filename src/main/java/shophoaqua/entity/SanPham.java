package shophoaqua.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "SANPHAM")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maSanPham;
	@OneToOne
	@JoinColumn(name = "maDanhMuc")
	DanhMucSanPham danhMucSanPham;
	private String tenSanPham;
	private String giatien;
	private String mota;
	private String hinhSanPham;
	private String gianhcho;
	private String luotmua;
	


	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "maSanPham")
	Set<ChiTietSanPham> chitienSanPham;
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable
	(
			name="CTKHUYENMAI",
			joinColumns = {@JoinColumn(name="maSanPham",referencedColumnName = "maSanPham")},
			inverseJoinColumns = {@JoinColumn(name="maKhuyenMai",referencedColumnName = "maKhuyenMai")}
	)
	Set<KhuyenMai> listKhuyenMai;

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
}
