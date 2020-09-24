package shophoaqua.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import shophoaqua.entity.DanhMucSanPham;
import shophoaqua.entity.GioHang;
import shophoaqua.entity.SanPham;
import shophoaqua.service.DanhMucService;
import shophoaqua.service.SanPhamService;

@Controller
@RequestMapping("/chitiet")
@SessionAttributes("giohang")
public class ChiTietSanPhamController {
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	DanhMucService danhMucService;

	@GetMapping("/{maSanPham}")
	@Transactional
	public String showChititet(@PathVariable int maSanPham, ModelMap model, HttpSession httpsession) 
	{
		try {
			SanPham cTTSanPham = sanPhamService.getListChiTietSPWithCode(maSanPham);
			List<DanhMucSanPham> listDanhMuc = danhMucService.getDanhMuc();
			model.addAttribute("cTTSanPham", cTTSanPham);
			model.addAttribute("listDanhMuc", listDanhMuc);
			if(null!= httpsession.getAttribute("giohang")) 
			{
				 List<GioHang> list =  (List<GioHang>) httpsession.getAttribute("giohang");
			     model.addAttribute("hang",list.size());
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		return "chitietsanpham";
	}
}
