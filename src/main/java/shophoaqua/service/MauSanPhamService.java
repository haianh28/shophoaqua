package shophoaqua.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shophoaqua.dao.MauSanPhamDAO;
import shophoaqua.entity.MauSanPham;
import shophoaqua.impl.MauSanPhamImp;
@Service
public class MauSanPhamService implements MauSanPhamImp {
	@Autowired
	MauSanPhamDAO mauSanPhamDAO;

	public List<MauSanPham> layMauSanPham() {
		// TODO Auto-generated method stub
		return mauSanPhamDAO.layMauSanPham();
	}

}
