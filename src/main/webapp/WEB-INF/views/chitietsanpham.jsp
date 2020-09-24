<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<meta charset="UTF-8">
<title>Chi Tiết</title>
</head>
<body>
	<!-- phần Trên -->
	<div id="header-chitiet" class="container-fluid">
		<nav class="navbar navbar-expand-sm bg-none navbar-none">
			<!-- Brand -->
			<a class="navbar-brand" href="#"><img
				src='<c:out value="${pageContext.request.contextPath}/resource/Image/Logo.png"/>'>

			</a>

			<!-- Links -->
			<ul class="navbar-nav navbar-center">
				<li class="nav-item"><a class="nav-link" href="#">TRANG CHỦ</a></li>
				<!-- Dropdown -->
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbardrop"
					data-toggle="dropdown"> Dropdown link </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">DỊCH VỤ</a> <a
							class="dropdown-item" href="#">LIÊN HỆ</a> <a
							class="dropdown-item" href="#">GIỚI THIỆU</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="#">SẢN PHẨM</a></li>
				<li class="nav-item"><a class="nav-link" href="#">DỊCH VỤ</a></li>
				<li class="nav-item"><a class="nav-link" href="#">LIÊN HỆ</a></li>
				<li class="nav-item"><a class="nav-link" href="#">GIỚI
						THIỆU</a></li>
			</ul>
			<ul class="navbar-nav ml-auto nav-flex-icons">
				<c:choose>
					<c:when test="${wordheader !=null}">
						<li class="nav-item"><a id="circle" class="nav-link"
							href="dangnhap">${wordheader}</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="dangnhap">ĐĂNG
								NHẬP</a></li>
					</c:otherwise>
				</c:choose>
				<li id="giohang" class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/giohang"> <img
						src='<c:out value="${pageContext.request.contextPath}/resource/Image/cart-shop.png"/>'>
						<c:choose>
							<c:when test="${hang>0}">
								<div class="circle-giohang">
									<span>${hang}</span>
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<span></span>
								</div>
							</c:otherwise>
						</c:choose>

				</a></li>
				</a>
				</li>
			</ul>
		</nav>
	</div>
	<!-- phần giữa -->
	<div class="container">
		<div class="row" style="margin-top: 20px;">
			<div class="col-sm-2 col-md-2">
				<h3>Danh Muc</h3>
				<ul class="mymenu">
					<c:forEach var="listdm" items="${listDanhMuc}">
						<li><h3>
								<a href="#">${listdm.getTenDanhMuc()}</a>
							</h3></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-sm-8 col-md-8">
				<div class="row">
					<div class="col-sm-4 col-md-4">
						<div class="chitietsanpham">
							<img id="duongdan" data-anh="${cTTSanPham.getHinhSanPham()}"
								src='<c:out value="${pageContext.request.contextPath}/resource/Image/SanPham/${cTTSanPham.getHinhSanPham()}"/>'>
							<br> <span id="tensp"
								data-masp="${cTTSanPham.getMaSanPham()}" class="ten">${cTTSanPham.getTenSanPham()}</span><br>
							<span id="giatien" data-giatien="${cTTSanPham.getGiatien()}"
								class="gia">${cTTSanPham.getGiatien()} VNĐ</span>
						</div>
					</div>
					<div class="col-sm-8 col-md-8">
						<table class="table">
							<tbody>
								<tr>
									<th>MÀU</th>
									<th>SIZE</th>
									<th>SỐ LƯỢNG</th>
									<th>ĐẶT HÀNG</th>
									<c:forEach var="chitiet"
										items="${cTTSanPham.getChitienSanPham()}">
										<tr>
											<th class="tenmau"
												data-mamau="${chitiet.getMauSanPham().getMaMau()}">${chitiet.getMauSanPham().getTenMau()}</th>
											<th class="size"
												data-masize="${chitiet.getSizeSanPham().getMaSize()}">${chitiet.getSizeSanPham().getSize()}</th>
											<th class="soluong">${chitiet.getSoluong()}</th>
											<th><button data-machitiet="${chitiet.getMaCTSanPham()}" class="btn-success btn-giohang">Giỏ
													Hàng</button></th>
													
										</tr>
									</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-sm-2 col-md-2">
				<h3>Mô Tả</h3>
				<span>${cTTSanPham.getMota()}</span>
			</div>
		</div>
	</div>
	<!--Phần dưới -->
	<div id="footer" class="container-fluid ">
		<div class="row ">

			<div class="col-sm-4 col-md-4 wow tada">
				<p>
					<span class="title-footer">THÔNG TIN SHOP</span>
				</p>
				<span>Với mong muốn cung cấp những loại hoa quả sạch đến tay
					người tiêu dùng Công Ty TNHH Phát triển Thương mại Phúc Linh được
					thành lập từ năm 2011.Bằng sự nỗ lực không ngừng nghỉ Phúc Linh đã
					trở thành một địa chỉ tin cậy – chuyên cung cấp các loại hoa quả</span>
			</div>

			<div class="col-sm-4 col-md-4 wow tada">
				<p>
					<span class="title-footer">LIÊN HỆ</span>
				</p>
				<span>Cửa hàng : P101, Nhà D Ngõ 10 Phố 8/3, Hai Bà Trưng, Hà
					Nội</span><br> <span>Điện Thoại: 024.6275.3582 – 098.237.4214</span><br>

			</div>

			<div class="col-sm-4 col-md-4 wow tada">
				<p>
					<span class="title-footer">GÓP Ý</span>
				</p>
				<form action="" method="post">
					<input name="tennv" class="material-textinput"
						style="margin-bottom: 8px;" type="text" placeholder="Email"><br>
					<textarea name="tuoi" rows="4" cols="50" placeholder="Nội Dung"></textarea>
					<button class="material-primary-button" style="margin-top: 8px;">ĐỒNG
						Ý</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>