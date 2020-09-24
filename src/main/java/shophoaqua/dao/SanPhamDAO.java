package shophoaqua.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import shophoaqua.entity.ChiTietHoaDon;
import shophoaqua.entity.ChiTietSanPham;
import shophoaqua.entity.SanPham;
import shophoaqua.impl.SanPhamImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamImp {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<SanPham> getListSanPhamLimit(int spbatdau,int socuoi) 
	{
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> listSanPham = new ArrayList<SanPham>();
		if(spbatdau < 0 && socuoi <0) {
		String query = "FROM SANPHAM";
		listSanPham = session.createQuery(query).getResultList();
		}else
		{
		String query = "FROM SANPHAM where maSanPham >'"+ spbatdau +"'and maSanPham <='"+socuoi+"'";
		listSanPham = session.createQuery(query).getResultList();
		}
		return listSanPham;

	}

	@Transactional
	public SanPham getListChiTietSPWithCode(int maSanPham) 
	{
		Session session = sessionFactory.getCurrentSession();
		String query = "FROM SANPHAM Where maSanPham=";
		SanPham sanPham = (SanPham) session.createQuery(query + maSanPham).getSingleResult();
		return sanPham;
	}
	
    @Transactional
	public List<SanPham> laySanPhamTheoDanhMuc(int id) {
		Session session = sessionFactory.getCurrentSession();
		String query = "FROM SANPHAM sp WHERE sp.danhMucSanPham.maDanhMuc="+id;
		List<SanPham> listSP = session.createQuery(query).getResultList();
		return listSP;
	}

	@Transactional
	public boolean xoaSanPham(int masp) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sanpham = session.get(SanPham.class, masp);
		Set<ChiTietSanPham> chitietsanpham = sanpham.getChitienSanPham();
		for (ChiTietSanPham ctsp : chitietsanpham) {
			session.createQuery("delete CTHOADON Where maCTSanPham=" + ctsp.getMaCTSanPham()).executeUpdate();
		}
		// dong vi chua can su dung toi vi chua co khuyen mai
		//session.createQuery("delete CTKHUYENMAI Where maSanPham=" + masp).executeUpdate();
		session.createQuery("delete CTSANPHAM Where maSanPham=" + masp).executeUpdate();
		session.createQuery("delete SANPHAM Where maSanPham=" + masp).executeUpdate();
		return true;
	}
    @Transactional
	public boolean themSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		int id =  (Integer) session.save(sanPham);
		return false;
	}
    @Transactional
	public void capNhatSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		session.update(sanPham);
	}

}
