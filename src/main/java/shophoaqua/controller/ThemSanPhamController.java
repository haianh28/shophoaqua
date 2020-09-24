package shophoaqua.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import shophoaqua.entity.DanhMucSanPham;
import shophoaqua.entity.MauSanPham;
import shophoaqua.entity.SanPham;
import shophoaqua.entity.SizeSanPham;
import shophoaqua.service.DanhMucService;
import shophoaqua.service.MauSanPhamService;
import shophoaqua.service.SanPhamService;
import shophoaqua.service.SizeSanPhamService;

@Controller
@RequestMapping("/ThemSanPham")
public class ThemSanPhamController {
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	DanhMucService danhMucServiec;
	@Autowired
	MauSanPhamService  mauSanPhamService;
	@Autowired
	SizeSanPhamService sizeSanPhamService;
	
	@GetMapping
	public String showThemSanPham(ModelMap model) {
		List<SanPham> listall = sanPhamService.getListSanPhamLimit(-1, -1);
		List<SanPham> listsp = sanPhamService.getListSanPhamLimit(0, 5);
		List<DanhMucSanPham> listdm = danhMucServiec.getDanhMuc();
		List<MauSanPham> listmau = mauSanPhamService.layMauSanPham();
		List<SizeSanPham> listsize = sizeSanPhamService.laySizeSanPham();
		// tong so page = do dai cua list san pham khi lay tat ca chia cho so page can
		// hien thi
		double sopage = Math.ceil(listall.size() / 5)+2;
		System.out.println(sopage + "--" + listall.size() + "--" + listall.size() / 5);
		model.addAttribute("listsp", listsp);
		model.addAttribute("listall", listall);
		model.addAttribute("sopage", sopage);
		model.addAttribute("danhmuc", listdm);
		model.addAttribute("mau", listmau);
		model.addAttribute("size", listsize);
		return "themsanpham";
	}
	
}
