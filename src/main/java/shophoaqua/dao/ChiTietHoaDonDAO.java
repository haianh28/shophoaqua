package shophoaqua.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import shophoaqua.entity.ChiTietHoaDon;
import shophoaqua.entity.ChiTietHoaDonId;
import shophoaqua.impl.ChiTietHoaDonImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDAO implements ChiTietHoaDonImp {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) 
	{
		Session session = sessionFactory.getCurrentSession();
		// bên khoa chinh id là kieu Emb nen tra ve 1 cai object chua khoa chinh
		ChiTietHoaDonId id =  (ChiTietHoaDonId) session.save(chiTietHoaDon);
		if (id != null) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

}
