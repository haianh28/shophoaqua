package shophoaqua.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import shophoaqua.entity.HoaDon;
import shophoaqua.impl.HoaDonImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDAO implements HoaDonImp {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public int themHoaDon(HoaDon hoadon) {
		// khai bao session
		Session session = sessionFactory.getCurrentSession();
		// khi save nó là 1 serializeable nên trả về 1 là đối tượng 2 là 1 cái id được
		// mã hóa
		int id =    (Integer) session.save(hoadon);
		if (id > 0) 
		{
			return id;
		} 
		else 
		{
			return 0;
		}
	}

}
