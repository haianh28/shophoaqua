package shophoaqua.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import shophoaqua.entity.SizeSanPham;
import shophoaqua.impl.SizeSanPhamImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SizeSanPhamDAO  implements SizeSanPhamImp{
@Autowired
SessionFactory sessionFactory;

@Transactional
public List<SizeSanPham> laySizeSanPham() {
	Session session = sessionFactory.getCurrentSession();
	String query = "from SIZESANPHAM";
	List<SizeSanPham> list = session.createQuery(query).getResultList();
	return list;
}
}
