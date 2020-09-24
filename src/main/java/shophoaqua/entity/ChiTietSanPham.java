package shophoaqua.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "CTSANPHAM")
public class ChiTietSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maCTSanPham;
	
	@OneToOne()
	@JoinColumn(name = "maSanPham")
	SanPham sanPham;
	
	@OneToOne()
	@JoinColumn(name = "maSize")
	SizeSanPham sizeSanPham;
	
	@OneToOne()
	@JoinColumn(name = "maMau")
	MauSanPham mauSanPham;
	
	private int soluong;
	private String ngaynhap;

	public int getMaCTSanPham() {
		return maCTSanPham;
	}

	public void setMaCTSanPham(int maCTSanPham) {
		this.maCTSanPham = maCTSanPham;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public SizeSanPham getSizeSanPham() {
		return sizeSanPham;
	}

	public void setSizeSanPham(SizeSanPham sizeSanPham) {
		this.sizeSanPham = sizeSanPham;
	}

	public MauSanPham getMauSanPham() {
		return mauSanPham;
	}

	public void setMauSanPham(MauSanPham mauSanPham) {
		this.mauSanPham = mauSanPham;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getNgaynhap() {
		return ngaynhap;
	}

	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}

}
