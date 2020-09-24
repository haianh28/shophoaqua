package shophoaqua.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "KHUYENMAI")
public class KhuyenMai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maKhuyenMai;
	private String tenKhuyenMai;
	private int giagiam;
	private String thoigianbatdau;
	private String thoigianketthuc;
	private String mota;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			joinColumns = {@JoinColumn(name="maKhuyenMai",referencedColumnName = "maKhuyenMai")},
			inverseJoinColumns = {@JoinColumn(name="maSanPham",referencedColumnName = "maSanPham")}
			)
	Set<SanPham> danhSachSanPham;

	public Set<SanPham> getDanhSachSanPham() {
		return danhSachSanPham;
	}

	public void setDanhSachSanPham(Set<SanPham> danhSachSanPham) {
		this.danhSachSanPham = danhSachSanPham;
	}

	public int getMaKhuyenMai() {
		return maKhuyenMai;
	}

	public void setMaKhuyenMai(int maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}

	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}

	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}

	public int getGiagiam() {
		return giagiam;
	}

	public void setGiagiam(int giagiam) {
		this.giagiam = giagiam;
	}

	public String getThoigianbatdau() {
		return thoigianbatdau;
	}

	public void setThoigianbatdau(String thoigianbatdau) {
		this.thoigianbatdau = thoigianbatdau;
	}

	public String getThoigianketthuc() {
		return thoigianketthuc;
	}

	public void setThoigianketthuc(String thoigianketthuc) {
		this.thoigianketthuc = thoigianketthuc;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

}
