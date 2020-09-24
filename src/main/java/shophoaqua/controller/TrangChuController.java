package shophoaqua.controller;



import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shophoaqua.entity.DanhMucSanPham;
import shophoaqua.entity.SanPham;
import shophoaqua.service.DanhMucService;
import shophoaqua.service.SanPhamService;



@Controller
@RequestMapping("/")
public class TrangChuController {
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	DanhMucService danhMucService;

	@GetMapping("/")
	@Transactional
	public String showTrangChu(ModelMap modelmap,HttpSession httpSession) {
        List<DanhMucSanPham> listDM = danhMucService.getDanhMuc();
		if(httpSession.getAttribute("user") != null){
			String email =(String) httpSession.getAttribute("user");
			String wordheader = email.substring(0,1).toUpperCase();
			modelmap.addAttribute("wordheader", wordheader);
		}
		List<SanPham> listSanPham = sanPhamService.getListSanPhamLimit(-1,-1);
			modelmap.addAttribute("listsp", listSanPham);
			modelmap.addAttribute("listDanhMuc",listDM);
		return "trangchu";

	}

	@PostMapping
	@Transactional
	public String themGopY(@RequestParam String tennv, @RequestParam int tuoi) {
		
		return "redirect:/";
	}
}
