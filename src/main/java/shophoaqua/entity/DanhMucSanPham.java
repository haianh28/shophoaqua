package shophoaqua.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "DANHMUCSANPHAM")
public class DanhMucSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maDanhMuc;
	private String tenDanhMuc;
	private String hinhDanhMuc;
	@OneToMany
	@JoinColumn(name = "maDanhMuc")
	Set<SanPham> listSanPham;

	public Set<SanPham> getListSanPham() {
		return listSanPham;
	}

	public void setListSanPham(Set<SanPham> listSanPham) {
		this.listSanPham = listSanPham;
	}

	public int getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public String getHinhDanhMuc() {
		return hinhDanhMuc;
	}

	public void setHinhDanhMuc(String hinhDanhMuc) {
		this.hinhDanhMuc = hinhDanhMuc;
	}

}
