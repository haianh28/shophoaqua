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

import shophoaqua.entity.DanhMucSanPham;
import shophoaqua.entity.SanPham;
import shophoaqua.service.DanhMucService;
import shophoaqua.service.SanPhamService;

@Controller
@RequestMapping("/SanPham")
public class SanPhamController {
	@Autowired
	DanhMucService danhMucService;
	@Autowired
	SanPhamService sanPhamService;

	@GetMapping("/{id}/{tenDanhMuc}")
	@Transactional
	public String showSanPham(ModelMap modelmap, HttpSession httpSession, @PathVariable int id,@PathVariable String tenDanhMuc) {
		List<DanhMucSanPham> listDM = danhMucService.getDanhMuc();
		modelmap.addAttribute("listDanhMuc", listDM);
		List<SanPham> listSP = sanPhamService.laySanPhamTheoDanhMuc(id);
		modelmap.addAttribute("listsp", listSP);
		modelmap.addAttribute("tenDanhMuc", tenDanhMuc);
		return "sanpham";
	}
}
