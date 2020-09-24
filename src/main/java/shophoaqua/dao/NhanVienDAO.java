package shophoaqua.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;


import shophoaqua.impl.NhanVienImp;
import shophoaqua.entity.NhanVien;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NhanVienDAO implements NhanVienImp
{
	@Autowired
	SessionFactory sessionFactory;
	

    @Transactional
	public boolean kiemTraDangNhap(String email, String matkhau) 
	{
		Session session = sessionFactory.getCurrentSession();
		try 
		{
			NhanVien nhanvien;
			nhanvien = (NhanVien) session
			.createQuery("from NHANVIEN where email ='" + email 
			+ "' AND matkhau='" + matkhau + "'").getSingleResult();
			if(nhanvien!=null) 
			{
				return true;
			}
			else
			{
				return false; // sai thì trả về giá trị false
			}
		}
		catch (Exception e) 
		{
			// lỗi thì trả về giá trị false
			return false;
		}
	}

    @Transactional
	public boolean themNhanVien(NhanVien nhanvien) 
    {
          Session session = sessionFactory.getCurrentSession();
          
          int id = (Integer) session.save(nhanvien);
          if(id>0)
          {
        	  return true;
          }
          else
          {
      		return false;
          }
	}
}
