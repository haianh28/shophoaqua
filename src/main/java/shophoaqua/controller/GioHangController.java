package shophoaqua.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import shophoaqua.entity.ChiTietHoaDon;
import shophoaqua.entity.ChiTietHoaDonId;
import shophoaqua.entity.GioHang;
import shophoaqua.entity.HoaDon;
import shophoaqua.service.ChiTietHoaDonService;
import shophoaqua.service.HoaDonService;

@Controller
@RequestMapping("/giohang")
public class GioHangController {
	@Autowired
	HoaDonService hoaDonService;
	
	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;

	
	@GetMapping
	public String showGioHang(ModelMap model , HttpSession httpsession) 
	{
		if(null!= httpsession.getAttribute("giohang")) 
		{
			 List<GioHang> list =  (List<GioHang>) httpsession.getAttribute("giohang");
		     model.addAttribute("hang",list.size());
		     model.addAttribute("listGH", list);
		}
		return "giohang";
	}
	
	
	
	// ở day do chung ta dung @Embeddable khong co Relesionship chi dinh 
	// moi quan he nen chung ta phai save chitiethoa don bang tay
	@PostMapping
	public String themHoaDon(HttpSession httpsession,@ModelAttribute HoaDon hoaDon) 
	{
		// khi nao co gio hang thi lam viec nay
		if(null!=httpsession.getAttribute("giohang"))
		{
			List<GioHang> listGH = (List<GioHang>) httpsession.getAttribute("giohang");
			//bang hoa don dang can luu vao 1 cai ct hoa don cho nen chung ta tao ra list de luu vao
			Set<ChiTietHoaDon> listCTHD = new HashSet<ChiTietHoaDon>();
			// them ma hoa don de ma hoa don khong bi null
			int idhoaDon = hoaDonService.themHoaDon(hoaDon);
			if(idhoaDon > 0)
			{
				// duyet gio hang de lay ma chitiethoadon
				
				for (GioHang gh : listGH) {
					//khai bao chitiethoadonid
					
					ChiTietHoaDonId ctHDId =new ChiTietHoaDonId();
					// truyen mã chi tiet san pham vao ct hoa don id
					
					ctHDId.setMaCTSanPham(gh.getMachitiet());
					ctHDId.setMaHoaDon(hoaDon.getMaHoaDon());
					// khai bao chitiethoadon
					
					ChiTietHoaDon cthd = new ChiTietHoaDon();
					//truyen chi tiet hoa don id vao bien ct hoa don id trong bang ct hoa don
					
					cthd.setChiTietHoaDonId(ctHDId);
					cthd.setGiatien(gh.getGiatien().toString());
					cthd.setSoluong(gh.getSoluong());
					
					chiTietHoaDonService.themChiTietHoaDon(cthd);
				}
			}
			else
			{
				System.out.println("them tb");
			}
			

		}

		return "giohang";
	}
}
