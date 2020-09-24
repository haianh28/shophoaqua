package shophoaqua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shophoaqua.dao.ChiTietHoaDonDAO;
import shophoaqua.entity.ChiTietHoaDon;
import shophoaqua.impl.ChiTietHoaDonImp;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImp{
       @Autowired
       ChiTietHoaDonDAO chiTietHoaDonDAO;
       
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		// TODO Auto-generated method stub
		return chiTietHoaDonDAO.themChiTietHoaDon(chiTietHoaDon);
	}

}
