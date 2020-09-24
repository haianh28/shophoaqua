package shophoaqua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shophoaqua.dao.HoaDonDAO;
import shophoaqua.entity.HoaDon;
import shophoaqua.impl.HoaDonImp;
@Service
public class HoaDonService implements HoaDonImp
{
	@Autowired
	HoaDonDAO hoaDonDAO;

	public int themHoaDon(HoaDon hoadon) 
	{
		//trả ra true or false
		return hoaDonDAO.themHoaDon(hoadon);
	}

}
