package shophoaqua.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import shophoaqua.entity.ChiTietSanPham;
import shophoaqua.entity.DanhMucSanPham;
import shophoaqua.entity.GioHang;
import shophoaqua.entity.JSon_SanPham;
import shophoaqua.entity.MauSanPham;
import shophoaqua.entity.SanPham;
import shophoaqua.entity.SizeSanPham;
import shophoaqua.service.MauSanPhamService;
import shophoaqua.service.NhanVienService;
import shophoaqua.service.SanPhamService;

@Controller
@RequestMapping("api/")
@SessionAttributes({ "user", "giohang" })
public class ApiController 
{
	@Autowired
	NhanVienService nhanVienService;
	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	ServletContext context;
	
	@GetMapping("KiemTraDangNhap")
	@ResponseBody
	public String kiemTraDangNhap(@RequestParam String email, @RequestParam String matkhau, ModelMap modelmap) 
	{
		boolean kiemTra = nhanVienService.kiemTraDangNhap(email, matkhau);
		modelmap.addAttribute("user", email);
		return "" + kiemTra;
	}

	@GetMapping("ThemGioHang")
	@ResponseBody
	public String themGioHang(@ModelAttribute GioHang giohang, HttpSession httpsession) 
	{
		if (null == httpsession.getAttribute("giohang")) 
		{
			giohang.setSoluong(1);
			// tao mang luu cac thuoc tinh cua doi tuong gio hang
			List<GioHang> giohangs = new ArrayList<GioHang>();
			giohangs.add(giohang);
			httpsession.setAttribute("giohang", giohangs);
			return giohangs.size() + "";
		} 
		else 
		{
			giohang.setSoluong(1);
			// tao cai list chua gio hang
			List<GioHang> listgh = (List<GioHang>) httpsession.getAttribute("giohang");

			// lay vi tri cua gia hang
			int vitri = kiemTraVTriGioHang(httpsession, giohang);
			// kiem tra vi tri gio hang neu chua co
			if (vitri == -1) 
			{
				// them list gio hang vao
				listgh.add(giohang);
			}
			// neu gio hang ton tai roi
			else 
			{
				// goi so luong cu bang cac truyen vi tri dang dung
				int soluongcu = listgh.get(vitri).getSoluong();
				// goi so luong moi bang cac truyen vi tri dang dung + 1
				int soluongmoi = soluongcu + 1;
				// truyen so luong moi vao list va goi vi tri dang dung ra va truyen so luong
				// moi vao
				listgh.get(vitri).setSoluong(soluongmoi);
			}
			return listgh.size() + "";
		}
	}

	@GetMapping("CapNhatGioHang")
	@ResponseBody
	public void capNhatGioHang(HttpSession httpsession, @ModelAttribute GioHang giohang) 
	{
		// kiểm tra session tồn tai
		if (null != httpsession.getAttribute("giohang")) {
			//
			List<GioHang> listgh = (List<GioHang>) httpsession.getAttribute("giohang");
			int vitri = kiemTraVTriGioHang(httpsession, giohang);
			listgh.get(vitri).setSoluong(giohang.getSoluong());
		}
	}

	@GetMapping("XoaGioHang")
	@ResponseBody
	public void xoaNhatGioHang(HttpSession httpsession, @ModelAttribute GioHang giohang) 
	{
		// kiểm tra session tồn tai
		if (null != httpsession.getAttribute("giohang")) {
			//
			List<GioHang> listgh = (List<GioHang>) httpsession.getAttribute("giohang");
			int vitri = kiemTraVTriGioHang(httpsession, giohang);
			listgh.remove(vitri);
		}
	}
	
	public int kiemTraVTriGioHang(HttpSession httpSession, @ModelAttribute GioHang giohang) 
	{
		List<GioHang> listgh = (List<GioHang>) httpSession.getAttribute("giohang");
		for (int i = 0; i < listgh.size(); i++) 
		{
			// Neu tim thanh cong thi tra ra vi tri gio hang
			if (listgh.get(i).getMasp() == giohang.getMasp() && listgh.get(i).getMamau() == giohang.getMamau()
					&& listgh.get(i).getMasize() == giohang.getMasize()) 
			{
				return i;
			}
		}
		// neu khong tim thay thi tra ra -1; boi vi o tren set cho no =1 thi 1-1 =0
		return -1;
	}
	// neu dung ajax long thi khai bao them con khong thi dung phuong thuc tra ve
	// nhu tren

//	@GetMapping("layGioHang")
//	@ResponseBody
//	public String laySoLuongGioHang(HttpSession httpsession) 
//	{
//		if(null!=httpsession.getAttribute("giohang"))
//		{
//		List<GioHang> listgh = (List<GioHang>) httpsession.getAttribute("giohang");
//		return listgh.size()+"";
//		}
//		return "";
//	}
	@GetMapping(path = "PhanTrang",produces = "text/plan;charset=utf-8")
	@ResponseBody
	public String layLimit(@RequestParam int spbatdau,@RequestParam int socuoi) 
	{
		String html="";
		List<SanPham> listsp = sanPhamService.getListSanPhamLimit(spbatdau,socuoi);
		for(SanPham sp : listsp) {
		html+="<tr> <td><input type='checkbox' value='"+sp.getMaSanPham()+"'></td>";
		html+="<td class='tensp' data-masp="+sp.getMaSanPham()+">"+sp.getTenSanPham()+"</td>";
		html+="<td class='giatien'>"+sp.getGiatien()+"</td>";
		html+="<td class='gianhcho'>"+sp.getGianhcho()+"</td>";
		html+="<td id='capnhatsanpham' class='btn btn-warning' data-capnhat="+sp.getMaSanPham()+">Sửa</td>";
		html+="</tr>";
		}
		return html;
	}
	@GetMapping("XoaSanPham")
	@ResponseBody
	public String xoaSanPham(@RequestParam int masp) 
	{
		sanPhamService.xoaSanPham(masp);
		return "";
	}
	@PostMapping("UploadFile")
	@ResponseBody
	public String uploadFile(MultipartHttpServletRequest request) {
		// hien tai getRealPath no dang o webapp no tra ra 1 thu muc de lay duong file
		String file_path=context.getRealPath("/resource/Image/SanPham/");
		// o day chi lay file name thoi 
		Iterator<String> listfile = request.getFileNames();
		// de lay cai files
		MultipartFile mpf = request.getFile(listfile.next());
		
		//l
		File file_save = new File(file_path+ mpf.getOriginalFilename());//getOriginalFilename() cong duoi file 
		// chep file vào thư muc bang cach
		try {
			mpf.transferTo(file_save);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(file_path);
		
		return "";
	}
	@PostMapping("ThemSanPham")
	@ResponseBody
	public void themSanPham(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		// JsonNode vua la 1 Jsonbject va JsonArray va day la cach path bang tay
		JsonNode jsonObject;
		try {
			SanPham sanPham = new SanPham();
			// luu 1 doi tuong json vao JsonNode
			jsonObject = objectMapper.readTree(dataJson);
			// goi class danh muc san pham 
			DanhMucSanPham danhmucsanpham = new DanhMucSanPham();
			// truyen gia tri vao
			danhmucsanpham.setMaDanhMuc(jsonObject.get("danhMucSanPham").asInt());
			System.out.println(danhmucsanpham);
			// tao 1 JsonNode de luu doi tuong chi tiet san pham
			JsonNode jsonchitiet = jsonObject.get("chitienSanPham");
			// chi tiet san pham la 1 list 
			Set<ChiTietSanPham> listctsp = new HashSet<ChiTietSanPham>();
			// dung for de duyet listctsp bang du lieu lay tu JsonNode
			for (JsonNode objectctsp : jsonchitiet) {
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
				// trong chi tiet co mausanpham va size san pham nen goi doi tuong ra truyen gia tri
				MauSanPham mausp = new MauSanPham();
				// lay gia tri tu JsonNode truyen vao
				mausp.setMaMau(objectctsp.get("mausanpham").asInt());
				
				SizeSanPham sizesp = new SizeSanPham();
				sizesp.setMaSize(objectctsp.get("sizesanpham").asInt());
				
				// truyen mamau,masize vao chitietsanpham co lien ket voi bang san pham
				chiTietSanPham.setMauSanPham(mausp);
				chiTietSanPham.setSizeSanPham(sizesp);
				chiTietSanPham.setSoluong(objectctsp.get("soluong").asInt());
				
				// add nhung ma lien quan den san pham vao chitietsanpham
				listctsp.add(chiTietSanPham);
			}
			// lay tat ca du lieu lien quan den san pham trong jsonObject ra
			String tensanpham = jsonObject.get("tenSanPham").asText();
			String giatien = jsonObject.get("giatien").asText();
			String mota = jsonObject.get("mota").asText();
			String hinhSanPham = jsonObject.get("hinhSanPham").asText();
			String gianhcho = jsonObject.get("gianhcho").asText();
            // gan gia tri vao san pham
			sanPham.setChitienSanPham(listctsp);
			sanPham.setDanhMucSanPham(danhmucsanpham);
			sanPham.setTenSanPham(tensanpham);
			sanPham.setGiatien(giatien);
			sanPham.setMota(mota);
			sanPham.setHinhSanPham(hinhSanPham);
			sanPham.setGianhcho(gianhcho);
			sanPhamService.themSanPham(sanPham);
			System.out.println(sanPham.getDanhMucSanPham().getMaDanhMuc());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@PostMapping("CapNhatSanPham")
	@ResponseBody
	public void xoaSanPham(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		// JsonNode vua la 1 Jsonbject va JsonArray va day la cach path bang tay
		JsonNode jsonObject;
		try {
			SanPham sanPham = new SanPham();
			// luu 1 doi tuong json vao JsonNode
			jsonObject = objectMapper.readTree(dataJson);
			// goi class danh muc san pham 
			DanhMucSanPham danhmucsanpham = new DanhMucSanPham();
			// truyen gia tri vao
			danhmucsanpham.setMaDanhMuc(jsonObject.get("danhMucSanPham").asInt());
			System.out.println(danhmucsanpham);
			// tao 1 JsonNode de luu doi tuong chi tiet san pham
			JsonNode jsonchitiet = jsonObject.get("chitienSanPham");
			// chi tiet san pham la 1 list 
			Set<ChiTietSanPham> listctsp = new HashSet<ChiTietSanPham>();
			// dung for de duyet listctsp bang du lieu lay tu JsonNode
			for (JsonNode objectctsp : jsonchitiet) {
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
				// trong chi tiet co mausanpham va size san pham nen goi doi tuong ra truyen gia tri
				MauSanPham mausp = new MauSanPham();
				// lay gia tri tu JsonNode truyen vao
				mausp.setMaMau(objectctsp.get("mausanpham").asInt());
				
				SizeSanPham sizesp = new SizeSanPham();
				sizesp.setMaSize(objectctsp.get("sizesanpham").asInt());
				
				// truyen mamau,masize vao chitietsanpham co lien ket voi bang san pham
				chiTietSanPham.setMauSanPham(mausp);
				chiTietSanPham.setSizeSanPham(sizesp);
				chiTietSanPham.setSoluong(objectctsp.get("soluong").asInt());
				
				// add nhung ma lien quan den san pham vao chitietsanpham
				listctsp.add(chiTietSanPham);
			}
			// lay tat ca du lieu lien quan den san pham trong jsonObject ra
			int masp = jsonObject.get("maSanPham").asInt();
			String tensanpham = jsonObject.get("tenSanPham").asText();
			String giatien = jsonObject.get("giatien").asText();
			String mota = jsonObject.get("mota").asText();
			String hinhSanPham = jsonObject.get("hinhSanPham").asText();
			String gianhcho = jsonObject.get("gianhcho").asText();
            // gan gia tri vao san pham
			sanPham.setMaSanPham(masp);
			sanPham.setChitienSanPham(listctsp);
			sanPham.setDanhMucSanPham(danhmucsanpham);
			sanPham.setTenSanPham(tensanpham);
			sanPham.setGiatien(giatien);
			sanPham.setMota(mota);
			sanPham.setHinhSanPham(hinhSanPham);
			sanPham.setGianhcho(gianhcho);
			sanPhamService.capNhatSanPham(sanPham);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@PostMapping(path="LaySanPhamTheoMa",produces = "application/json ; charset=utf8")
	@ResponseBody
	public JSon_SanPham laySanPhamTheoMa(@RequestParam int masp ){
		JSon_SanPham json_SanPham = new JSon_SanPham();
		SanPham sanPham = sanPhamService.getListChiTietSPWithCode(masp);
		json_SanPham.setMaSanPham(sanPham.getMaSanPham());
		json_SanPham.setTenSanPham(sanPham.getTenSanPham());
		json_SanPham.setGiatien(sanPham.getGiatien());
		json_SanPham.setMota(sanPham.getMota());
		json_SanPham.setHinhSanPham(sanPham.getHinhSanPham());
		json_SanPham.setGianhcho(sanPham.getGianhcho());
		json_SanPham.setLuotmua(sanPham.getLuotmua());
		// o day chung ta phai new 1 danh muc de khong vuong khoa ngoai
		//cai ma dan toi loi proxy
		// viec thu 2 la phai truy du lieu cua san pham vao danh muc da nhe
		DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
		danhMucSanPham.setMaDanhMuc(sanPham.getDanhMucSanPham().getMaDanhMuc());
		danhMucSanPham.setTenDanhMuc(sanPham.getDanhMucSanPham().getTenDanhMuc());
		// va cuoi cung la truyen cai doi tuong do vao
		json_SanPham.setDanhMucSanPham(danhMucSanPham);
		// truyen gia tri vao list chi tiet 
		Set<ChiTietSanPham> listctsp = new HashSet<ChiTietSanPham>();
		for (ChiTietSanPham value : sanPham.getChitienSanPham()) {
			ChiTietSanPham ctsp = new ChiTietSanPham();
			ctsp.setMaCTSanPham(value.getMaCTSanPham());
			
		// them bang mau vao
			MauSanPham mau = new MauSanPham();
			mau.setMaMau(value.getMauSanPham().getMaMau());
			mau.setTenMau(value.getMauSanPham().getTenMau());

			
			// them bang size vao chi tiet
			SizeSanPham size = new SizeSanPham();
			size.setMaSize(value.getSizeSanPham().getMaSize());
			size.setSize(value.getSizeSanPham().getSize());
			
			ctsp.setSoluong(value.getSoluong());
			ctsp.setMauSanPham(mau);
			ctsp.setSizeSanPham(size);
			// bay gio goi cai list va add doi tuong chi tiet vao
			listctsp.add(ctsp);
		}
		// truyen thang danh muc vao Json_SanPham
		json_SanPham.setDanhMucSanPham(danhMucSanPham);
		// lay thang list vao truyen gia tri lay o tren truyen vao
		json_SanPham.setChitienSanPham(listctsp);
		
		
		return json_SanPham;
	}
}
