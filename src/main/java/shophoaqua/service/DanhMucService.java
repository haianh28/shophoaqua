package shophoaqua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shophoaqua.dao.DanhMucDAO;
import shophoaqua.entity.DanhMucSanPham;
import shophoaqua.impl.DanhMucImp;

@Service
public class DanhMucService implements DanhMucImp {
	@Autowired
	DanhMucDAO danhMucDAO;

	public List<DanhMucSanPham> getDanhMuc() 
	{
		return danhMucDAO.getDanhMuc();
	}

}
