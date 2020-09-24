package shophoaqua.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "HOADON")
public class HoaDon 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maHoaDon;
	private String tenKhachHang;
	private String sdt;
	private String diachigiahang;
	private boolean tinhtrang;
	private String hinhthucgiaohang;
	private String ngaylap;
	private String ghichu;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "maCTSanPham")
	Set<ChiTietHoaDon> chiTietHoaDon;

	public int getMaHoaDon() 
	{
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) 
	{
		this.maHoaDon = maHoaDon;
	}

	public String getTenKhachHang() 
	{
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) 
	{
		this.tenKhachHang = tenKhachHang;
	}

	public String getSdt() 
	{
		return sdt;
	}

	public void setSdt(String sdt) 
	{
		this.sdt = sdt;
	}

	public String getDiachigiahang() 
	{
		return diachigiahang;
	}

	public void setDiachigiahang(String diachigiahang) 
	{
		this.diachigiahang = diachigiahang;
	}

	public boolean isTinhtrang() 
	{
		return tinhtrang;
	}

	public void setTinhtrang(boolean tinhtrang) 
	{
		this.tinhtrang = tinhtrang;
	}

	public String getNgaylap() 
	{
		return ngaylap;
	}

	public void setNgaylap(String ngaylap) 
	{
		this.ngaylap = ngaylap;
	}

	public Set<ChiTietHoaDon> getChiTietHoaDon() 
	{
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(Set<ChiTietHoaDon> chiTietHoaDon) 
	{
		this.chiTietHoaDon = chiTietHoaDon;
	}

	public String getHinhthucgiaohang() {
		return hinhthucgiaohang;
	}

	public void setHinhthucgiaohang(String hinhthucgiaohang) {
		this.hinhthucgiaohang = hinhthucgiaohang;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

}
