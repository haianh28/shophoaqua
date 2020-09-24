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
					data-toggle="dropdown"> SẢN PHẨM </a>
					<ul class="dropdown-menu" style="background-color: #199f19;">
						<c:forEach var="listdm" items="${listDanhMuc}">
							<li><a class="dropdown-item"
								href="${pageContext.request.contextPath}/SanPham/${listdm.getMaDanhMuc()}">${listdm.getTenDanhMuc()}</a>
							</li>
							<li role="separator" class="driver"></li>
						</c:forEach>
					</ul></li>
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
			<div class="col-sm-10 col-md-10">
				<div id="titile-sanpham" class="container">
					<span>${tenDanhMuc}</span>
					<div class="row" style="margin-top: 42px;">
						<c:forEach var="list" items="${listsp}">
							<div class="col-md-4 col-sm-6 wow zoomIn">
								<a href="${pageContext.request.contextPath}/chitiet/${list.getMaSanPham()}">
									<div class="sanpham">
										<img
											src='<c:out value="${pageContext.request.contextPath}/resource/Image/SanPham/${list.getHinhSanPham()}"/>'>
										<br> <span class="ten">${list.getTenSanPham()}</span><br>
										<span class="gia">${list.getGiatien()} Đ</span>
									</div>
								</a>
							</div>
						</c:forEach>
					</div>

				</div>
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