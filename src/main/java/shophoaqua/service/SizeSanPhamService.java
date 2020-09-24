package shophoaqua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shophoaqua.dao.SizeSanPhamDAO;
import shophoaqua.entity.SizeSanPham;
import shophoaqua.impl.SizeSanPhamImp;

@Service
public class SizeSanPhamService implements SizeSanPhamImp {
	@Autowired
	SizeSanPhamDAO sizeSanPham;

	public List<SizeSanPham> laySizeSanPham() {
		// TODO Auto-generated method stub
		return sizeSanPham.laySizeSanPham();
	}

}
