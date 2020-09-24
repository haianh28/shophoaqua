package shophoaqua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shophoaqua.dao.NhanVienDAO;
import shophoaqua.entity.NhanVien;
import shophoaqua.impl.NhanVienImp;

@Service
public class NhanVienService implements NhanVienImp
{
	@Autowired
	NhanVienDAO nhanVienDAO;

	public boolean kiemTraDangNhap(String email, String matkhau) {
		// TODO Auto-generated method stub
		boolean kiemtra = nhanVienDAO.kiemTraDangNhap(email , matkhau);
		return kiemtra;
	}

	public boolean themNhanVien(NhanVien nhanvien) {
		boolean kiemTraThemNhanVien = nhanVienDAO.themNhanVien(nhanvien);
		return kiemTraThemNhanVien;
	}
	

	
	
}
