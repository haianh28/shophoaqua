<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<meta charset="UTF-8">
<title>TRANG CHỦ</title>
</head>
<body>
	<!-- phần Trên -->
	<div id="header" class="container-fluid">
		<nav class="navbar navbar-expand-sm bg-none navbar-none">
			<!-- Brand -->
			<a class="navbar-brand" href="#"><img
				src='<c:out value="${pageContext.request.contextPath}/resource/Image/Logo.png"/>'></a>

			<!-- Links -->
			<ul class="navbar-nav navbar-center">
				<li class="nav-item"><a class="nav-link" href="#">TRANG CHỦ</a></li>
				<!-- Dropdown -->
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbardrop"
					data-toggle="dropdown"> SẢN PHẨM </a>
					<ul class="dropdown-menu" style="background-color: #199f1900;">
					<c:forEach var="listdm" items="${listDanhMuc}">
						<li>
								<a class="dropdown-item" href="${pageContext.request.contextPath}/SanPham/${listdm.getMaDanhMuc()}/${listdm.getTenDanhMuc()}">${listdm.getTenDanhMuc()}</a>
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
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/giohang"><img
						src='<c:out value="${pageContext.request.contextPath}/resource/Image/cart-shop.png"/>'></a></li>
				</a>
				</li>
			</ul>
		</nav>
		<div class="event_header container wow rubberBand">
			<span>Ngày 16/4 - 24/4/2020</span><br> <span class="event_sale">Mua
				1 Tặng 1</span><br>
			<button>XEM NGAY</button>
		</div>
	</div>
	<!-- phần Thân -->
	<div id="info" class="container">
		<div class="row wow fadeInUp" data-wow-duration="1s"">

			<div class="col-12 col-md-3">
				<img src='<c:out value="${pageContext.request.contextPath}/resource/Image/nguongoc.png"/>'> <br>
				<span class="content">NGUỒN GỐC</span>
				<hr>
				<br> <span class="introdue">Cam kết hàng hoa quả sạch có
					nguồn gốc xuất xứ thương hiệu nổi tiếng ở Việt Nam.</span>
			</div>
			<div class="col-12 col-md-3">
				<img src='<c:out value="resource/Image/tuoingon.png"/>'> <br>
				<span class="content">TƯƠI NGON</span>
				<hr>
				<br> <span class="introdue">Hoa quả sạch luôn tươi ngon
					và được bảo quản sạch sẽ, không dùng hóa chất bảo quản.</span>
			</div>
			<div class="col-12 col-md-3">
				<img src='<c:out value="resource/Image/trongluong.png"/>'> <br>
				<span class="content">TRỌNG LƯỢNG</span>
				<hr>
				<br> <span class="introdue">Cam kết trọng lượng đúng như
					Quý khách yêu cầu chính xác đến từng Gram, không gian dối về trọng
					lượng cũng như số lượng.</span>
			</div>
			<div class="col-12 col-md-3">
				<img src='<c:out value="resource/Image/vanchuyen.png"/>'> <br>
				<span class="content">VẬN CHUYỂN</span>
				<hr>
				<br> <span class="introdue">Miễn phí vận chuyển nội
					thành cho các đơn hàng trị giá từ 1 triệu đồng, khác phí từ 20,000đ
					đến 30,000đ mỗi đơn hàng tùy địa điểm. </span><br> <a
					class="introdue" href="#">Xem chi tiết </a>
			</div>

		</div>

	</div>
	<div id="titile-sanpham" class="container">
		<span>DANH SÁCH SẢN PHẨM</span>
		<div class="row" style="margin-top: 42px;">
			<c:forEach var="list" items="${listsp}">
				<div class="col-md-3 col-sm-6 wow zoomIn">
					<a href="${pageContext.request.contextPath}/chitiet/${list.getMaSanPham()}">
						<div class="sanpham">
							<img src='<c:out value="${pageContext.request.contextPath}/resource/Image/SanPham/${list.getHinhSanPham()}"/>'>
							<br> <span class="ten">${list.getTenSanPham()}</span><br>
							<span class="gia">${list.getGiatien()} Đ</span>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>

	</div>
	<!-- ket thuc list -->
	</div>
	<!-- phần Dưới -->
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