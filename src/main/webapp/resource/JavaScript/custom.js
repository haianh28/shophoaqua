$(document).ready(function() {
	var masanpham=0;
			$("#dong").click(function() {
				$(this).addClass("input-icon-email");
				var chuoi = $("#dong").attr("data");
			});
			$("#btndangnhap").click(function() {
				var emails = $("#email").val();
				var matkhaus = $("#matkhau").val();

				$.ajax({
					url : "/shophoaqua/api/KiemTraDangNhap",
					type : "GET",
					data : {
						email : emails,
						matkhau : matkhaus
					},
					success : function(value) {
						if (value == "true") {
							var url = window.location.href;
							var urlnow = url.replace("dangnhap", "");
							window.location = urlnow;
						} else {
							$("#btnketqua").text("Đăng nhập thất bại");
							
							return;
						}
					}
				})

			});
			$("#dangnhap").click(function() {
				$(this).addClass("actived");
				$("#dangky").removeClass("actived")
				$(".container-login-form").show();
				$(".container-singup-form").hide();
			});
			$("#dangky").click(function() {
				$(this).addClass("actived");
				$("#dangnhap").removeClass("actived")
				$(".container-login-form").hide();
				$(".container-singup-form").show();
			});
			$(".btn-giohang").click(
					function() {
						var machitiet = $(this).attr("data-machitiet");
						var masp = $("#tensp").attr("data-masp");
						var mamau = $(this).closest("tr").find(".tenmau").attr(
								"data-mamau");
						var masize = $(this).closest("tr").find(".size").attr(
								"data-masize");
						var tenmau = $(this).closest("tr").find(".tenmau")
								.text();
						var size = $(this).closest("tr").find(".size").text();
						var soluong = $(this).closest("tr").find(".soluong")
								.text();
						var tensp = $("#tensp").text();
						var giatien = $("#giatien").attr("data-giatien");
						var anh = $("#duongdan").attr("data-anh");
						$.ajax({
							url : "/shophoaqua/api/ThemGioHang",
							type : "GET",
							data : {
								machitiet : machitiet,
								masp : masp,
								mamau : mamau,
								masize : masize,
								tensp : tensp,
								giatien : giatien,
								tenmau : tenmau,
								tensize : size,
								soluong : soluong,
								duongdanhinh : anh
							},
							success : (function(value) {
								$("#giohang").find("div").addClass(
										"circle-giohang");
								$("#giohang").find("div").html(
										"<span>" + value + "</span>");
							})
						})
						// }).done(function() {
						// $.ajax({
						// url:"/shophoaqua/api/layGioHang",
						// type:"GET",
						// // value duoc hung gia tri tra ve tu phuong thuc
						// @GetMapping("layGioHang")
						// success:(function(value) {
						//						
						// $("#giohang").find("div").addClass("circle-giohang");
						// $("#giohang").find("div").html("<span>"+value+"</span>");
						// })
						// })
						// })
					});
			function ganTongTienGioHang() {
				// duyệt vòng for trong class của jquery
				var tongtiensp = 0;
				$(".giatien").each(
						function(chaytruoc) {
							// lấy text hien thi ở ngoai
							var giatien = $(this).attr("data-giatien");
							var soluong = $(this).closest("tr").find(
									".soluong-giohang").val();
							var tongtien = parseInt(giatien) * soluong;
							// format gia tri
							var format = parseFloat(tongtien).toFixed(3)
									.replace(/(\d)(?=(\d{3})+\.)/g, "$1.")
									.toString();
							// in ra chuoi da format
							// o day dung if de luong chay tren thực hien trước
							// không sửa rồi
							// mới in ra
							$(this).html(format);
							// tinh tong tien all san pham
							tongtiensp = tongtiensp + tongtien;
							var formattongtiensp = tongtiensp.toFixed(3)
									.replace(/(\d)(?=(\d{3})+\.)/g, "$1.")
									.toString();
							// format tong so tien
							$("#tongtien").html(formattongtiensp + " VND");
						})

			}
			ganTongTienGioHang();
			$(".soluong-giohang").change(
					function() {
						// lay gia tri của so luong
						var sl = $(this).val();
						// lay gia tri cua gia tien
						var giatien = $(this).closest("tr").find(".giatien")
								.attr("data-giatien");
						// tinh tong don gia = so luong * gia tien
						var tongtien = sl * parseInt(giatien);
						// regex chuoi tong tien sang dang tien te
						// toFixed(3) có 3 so 0 dung cuoi
						// replace(/(\d)(?=(\d{3})+\.)/g,"$1.") cu 3 so thi cach
						// nhau boi dau
						// cham
						// "$1." so dung dau trong chuoi tien te
						var format = tongtien.toFixed(3).replace(
								/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
						// click vao chính class do co dư kien click-> tim den
						// the cha của class
						// do -> tim den class chứa no
						// -> html tiem cai gia tri vào noi duoc goi den
						$(this).closest("tr").find(".giatien").html(format);
						ganTongTienGioHang();
						var masps = $(this).closest("tr").find(".tensp").attr(
								"data-masp");
						var mamau = $(this).closest("tr").find(".tenmau").attr(
								"data-mamau");
						var masize = $(this).closest("tr").find(".size").attr(
								"data-masize");
						$.ajax({
							url : "/shophoaqua/api/CapNhatGioHang",
							type : "GET",
							data : {
								masp : masps,
								mamau : mamau,
								masize : masize,
								soluong : sl
							}
						})
					})
			$(".xoagiohang").click(
					function() {
						// khai bao bien it voi chinh class dang click
						var it = $(this)
						var masps = $(this).closest("tr").find(".tensp").attr(
								"data-masp");
						var mamau = $(this).closest("tr").find(".tenmau").attr(
								"data-mamau");
						var masize = $(this).closest("tr").find(".size").attr(
								"data-masize");
						$.ajax({
							url : "/shophoaqua/api/XoaGioHang",
							type : "GET",
							data : {
								masp : masps,
								mamau : mamau,
								masize : masize
							},
							success : function(value) {
								it.closest("tr").remove();
								ganTongTienGioHang();
							}
						})
					})

			$("body").on("click", ".pagin-item", function() {
				$(".pagin-item").removeClass("active");
				$(this).addClass("active");
				var sotrang = $(this).text();
				var sobatdau = (sotrang - 1) * 5;
				var socuoi = (sotrang) * 5
				$.ajax({
					url : "/shophoaqua/api/PhanTrang",
					type : "GET",
					data : {
						spbatdau : sobatdau,
						socuoi : socuoi,
					},
					success : function(value) {
						var body = $("#table-sanpham").find("tbody");
						body.empty();
						body.append(value);
					}
				})

			})
			$("#check-all").change(function() {
				if (this.checked) {
					$("#table-sanpham input").each(function() {
						$(this).attr("checked", true);
					})
				} else {
					$("#table-sanpham input").each(function() {
						$(this).attr("checked", false);
					})
				}
			})

			$("#xoasanpham").click(function() {
				$("#table-sanpham > tbody input:checked").each(function() {
					var masp = $(this).val();
					var it = $(this);
					$.ajax({
						url : "/shophoaqua/api/XoaSanPham",
						type : "GET",
						data : {
							masp : masp
						},
						success : function(value) {
							it.closest("tr").remove();
						}
					})
				})
			})
			var files = [];
			var tenhinh = [];
			$("#hinhSanPham").change(function(event) {
				// tra ra 1 cai file chua trong file server tomcat
				files = event.target.files;
				tenhinh = files[0].name;
				forms = new FormData();
				forms.append("file", files[0])
				$.ajax({
					url : "/shophoaqua/api/UploadFile",
					type : "POST",
					data : forms,
					contentType : false,
					processData : false,
					enctype : "multipart/form-data",
					success : function(value) {

					}
				})
			})
			$("Body").on("click",".btn-chitiet",function() {
						$(this).remove(); // remove chinh no
						// sao chep 1 doan html nao do và xoa thuoc tinh id
						// trong do di
						var chitietclone = $("#chitietsanpham").clone()
								.removeAttr("id");
						$("#contenerchitietsanpham").append(chitietclone);
					})
			$("#themsanpham").click(function(event) {
				// phuong thuc ngan trinh duyen xu ly
				event.preventDefault()
				// lay du lieu trong form va chuyen no ve mot mang Array
				var formdata = $("#form-sanpham").serializeArray();
				// tao 1 doi tuong json
				json = {};
				// muon chuyen mang sang doi tuong json
				arraychitiet = [];

				$.each(formdata, function(i, field) {
					json[field.name] = field.value;
				});
				$("#contenerchitietsanpham > .chitietsanpham").each(function() {
					// khai bao 1 doi tuong chi tiet
					objectchitiet = {};
					// lay value cua chitietsanpham
					mamau = $(this).find('select[name="mausanpham"]').val();
					masize = $(this).find('select[name="sizesanpham"]').val();
					soluong = $(this).find('input[name="soluong"]').val();

					// add du lieu lay ra cho vao mangs
					// tao mot mang
					objectchitiet['mausanpham'] = mamau;
					objectchitiet['sizesanpham'] = masize;
					objectchitiet['soluong'] = soluong;

					// lay xong push tat ca vao doi tuong objectchitiet
					arraychitiet.push(objectchitiet);
				})
				// tao chuoi json bang mang
				json["chitienSanPham"] = arraychitiet;
				json["hinhSanPham"] = tenhinh;
				console.log(json);
				$.ajax({
					url : "/shophoaqua/api/ThemSanPham",
					type : "POST",
					data : {
						dataJson : JSON.stringify(json)
					},
					success : function(value) {

					}
				})
			})
			$("#capnhat").click(function(event) {
				// phuong thuc ngan trinh duyen xu ly
				event.preventDefault()
				// lay du lieu trong form va chuyen no ve mot mang Array
				var formdata = $("#form-sanpham").serializeArray();
				// tao 1 doi tuong json
				json = {};
				// muon chuyen mang sang doi tuong json
				arraychitiet = [];

				$.each(formdata, function(i, field) {
					json[field.name] = field.value;
				});
				$("#contenerchitietsanpham > .chitietsanpham").each(function() {
					// khai bao 1 doi tuong chi tiet
					objectchitiet = {};
					// lay value cua chitietsanpham
					mamau = $(this).find('select[name="mausanpham"]').val();
					masize = $(this).find('select[name="sizesanpham"]').val();
					soluong = $(this).find('input[name="soluong"]').val();

					// add du lieu lay ra cho vao mangs
					// tao mot mang
					objectchitiet['mausanpham'] = mamau;
					objectchitiet['sizesanpham'] = masize;
					objectchitiet['soluong'] = soluong;

					// lay xong push tat ca vao doi tuong objectchitiet
					arraychitiet.push(objectchitiet);
				})
				// tao chuoi json bang mang
				json["maSanPham"] = masanpham;
				json["chitienSanPham"] = arraychitiet;
				json["hinhSanPham"] = tenhinh;
				console.log(json);
				$.ajax({
					url : "/shophoaqua/api/CapNhatSanPham",
					type : "POST",
					data : {
						dataJson : JSON.stringify(json)
					},
					success : function(value) {
                     console.log(value)
					}
				})
			})
			$("body").on("click", "#capnhatsanpham", function() 
					{
				masanpham = $(this).attr("data-capnhat");
				$("#capnhat").removeClass("hidden");
				$("#thoat").removeClass("hidden");
				$("#themsanpham").addClass("hidden")
				$.ajax({
					url : "/shophoaqua/api/LaySanPhamTheoMa",
					type : "POST",
					data : {
						masp : masanpham,
					},
					success : function(value) {
						$("#tenSanPham").val(value.tenSanPham)
						$("#giatien").val(value.giatien)
						$("#mota").val(value.mota)
						if (value.gianhcho === "nam") {
							$("#rd-nam").prop("checked", true);
						} else {
							$("#rd-nu").prop("checked", true);
						}
						$("#danhMucSanPham").val(value.danhMucSanPham.maDanhMuc);
						$("#contenerchitietsanpham").html("");
						var countchitiet = value.chitienSanPham.length;
						alert(countchitiet);
						for(var i=0; i < countchitiet;i++){
							var chitietclone = $("#chitietsanpham").clone().removeAttr("id");
							if(i < countchitiet){
								 chitietclone.find(".btn-chitiet").remove();
							}
							if(i===0)
							{
								$("#chitietsanpham").show();
							}
							chitietclone.find("#mausanpham").val(value.chitienSanPham[i].mauSanPham.maMau);
							chitietclone.find("#sizesanpham").val(value.chitienSanPham[i].sizeSanPham.maSize);
							chitietclone.find("#soluong").val(value.chitienSanPham[i].soluong);
							$("#contenerchitietsanpham").append(chitietclone);
						}
					}
				})
			})
			$("#capnhat").click(function() {
				$("#capnhat").addClass("hidden");
				$("#thoat").addClass("hidden");
				$("#themsanpham").removeClass("hidden");
				
			})
		})