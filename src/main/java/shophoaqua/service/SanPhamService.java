package shophoaqua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shophoaqua.dao.SanPhamDAO;
import shophoaqua.entity.SanPham;
import shophoaqua.impl.SanPhamImp;

@Service
public class SanPhamService implements SanPhamImp 
{
	@Autowired
	SanPhamDAO sanPhamDAO;

	public List<SanPham> getListSanPhamLimit(int spbatdau,int socuoi) 
	{
		return sanPhamDAO.getListSanPhamLimit(spbatdau,socuoi);
	}

	public SanPham getListChiTietSPWithCode(int maSanPham) 
	{
		return sanPhamDAO.getListChiTietSPWithCode(maSanPham);
	
	}

	public List<SanPham> laySanPhamTheoDanhMuc(int id) {
		
		return sanPhamDAO.laySanPhamTheoDanhMuc(id);
	}

	public boolean xoaSanPham(int masp) {
		// TODO Auto-generated method stub
		return sanPhamDAO.xoaSanPham(masp);
	}

	public boolean themSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.themSanPham(sanPham);
	}

	public void capNhatSanPham(SanPham sanPham) {
		sanPhamDAO.capNhatSanPham(sanPham);
	}

}
