package shophoaqua.impl;

import java.util.List;

import shophoaqua.entity.SanPham;

public interface SanPhamImp {

	List<SanPham> getListSanPhamLimit(int sodau,int socuoi);
	SanPham getListChiTietSPWithCode(int maSanPham);
	List<SanPham> laySanPhamTheoDanhMuc(int id);
	boolean xoaSanPham(int masp);
	// khi them thi truyen ca doi tuong vao
	boolean themSanPham(SanPham sanPham);
	void capNhatSanPham(SanPham sanPham);
}
