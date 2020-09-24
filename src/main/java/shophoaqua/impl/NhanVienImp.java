package shophoaqua.impl;



import shophoaqua.entity.NhanVien;


public interface NhanVienImp 
{
	boolean kiemTraDangNhap(String email, String matkhau);
	boolean themNhanVien(NhanVien nhanvien);
}
