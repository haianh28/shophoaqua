package shophoaqua.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import shophoaqua.entity.MauSanPham;
import shophoaqua.impl.MauSanPhamImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MauSanPhamDAO implements MauSanPhamImp {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<MauSanPham> layMauSanPham() {
		Session session = sessionFactory.getCurrentSession();
		String query = "from MAUSANPHAM";
		List<MauSanPham> list = session.createQuery(query).getResultList();
		return list;
	}

}
