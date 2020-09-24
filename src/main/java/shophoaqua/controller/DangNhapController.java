package shophoaqua.controller;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import shophoaqua.entity.NhanVien;
import shophoaqua.service.NhanVienService;


@Controller
@RequestMapping("/dangnhap")
public class DangNhapController 
{
	@Autowired
	NhanVienService nhanVienService;

	@GetMapping
	public String Show() 
	{
		return "dangnhap";
	}
	public static final Pattern VALID_EMAIL_REGEX = 
	Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
	public static boolean validate(String email)
	{
		Matcher matcher = VALID_EMAIL_REGEX.matcher(email);
		return matcher.find();
	}
	@PostMapping
	public String dangKy(@RequestParam String email,@RequestParam String matkhau,@RequestParam String nhaplaimatkhau,ModelMap map)
	{
		boolean checkEmail = validate(email);
		if(checkEmail) 
		{
			if(matkhau.equals(nhaplaimatkhau)) 
			{
				NhanVien nhanvien = new NhanVien();
				nhanvien.setEmail(email);
				nhanvien.setTenDangNhap(email);
				nhanvien.setMatkhau(matkhau);
				boolean checkSingup = nhanVienService.themNhanVien(nhanvien);
				if(checkSingup)
				{
					map.addAttribute("CheckSingUp", "Tạo Tại khoản thành công !");
				}
				else
				{
					map.addAttribute("CheckSingUp", "Tạo tài khoản thành công");
				}
			}
			else
			{
				map.addAttribute("CheckSingUp", "Mật khẩu nhập lại không trùng khớp !");
			}
		}
		else
		{
			map.addAttribute("CheckSingUp", "Vui lòng nhập đúng định dạng Email !");
		}
		return "dangnhap" ;
	}
}
