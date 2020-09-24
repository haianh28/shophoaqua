package shophoaqua.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import shophoaqua.entity.DanhMucSanPham;
import shophoaqua.impl.DanhMucImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDAO implements DanhMucImp {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<DanhMucSanPham> getDanhMuc() {
		Session session = sessionFactory.getCurrentSession();
		String query = "from DANHMUCSANPHAM";
		List<DanhMucSanPham> listDM = session.createQuery(query).getResultList();
		return listDM;
	}
	

}
