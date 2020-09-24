package shophoaqua.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDonId implements Serializable
{

	private int maHoaDon;
	private int maCTSanPham;

	public int getMaHoaDon() 
	{
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) 
	{
		this.maHoaDon = maHoaDon;
	}

	public int getMaCTSanPham() 
	{
		return maCTSanPham;
	}

	public void setMaCTSanPham(int maCTSanPham) 
	{
		this.maCTSanPham = maCTSanPham;
	}

}
