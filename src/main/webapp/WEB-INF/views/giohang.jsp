<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<meta charset="UTF-8">
<title>Giỏ Hàng</title>
</head>
<body>
	<!-- phần Trên -->
	<div id="header-giohang" class="container-fluid">
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
				<li id="giohang" class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/giohang">
						<img
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
		<div class="row">

			<div class="col-md-8 col-sm-12">
				<h3>Danh sách sản phẩm đã chọn</h3>
				<table class="table table-borderless">
					<thead>
						<tr>
							<th>Ảnh</th>
							<th>Tên Sản phẩm</th>
							<th>Màu sản phẩm</th>
							<th>SIZE</th>
							<th>Số Lượng</th>
							<th>Giá Tiền</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sp" items="${listGH}">
							<tr data-machitiet="${sp.getMachitiet()}">
								<td><img id="anhgiohang"
									src='<c:out value="${pageContext.request.contextPath}/resource/Image/SanPham/${sp.getDuongdanhinh()}"/>'></td>
								<td class="tensp" data-masp="${sp.getMasp()}">${sp.getTensp()}
								</th>
								<td class="tenmau" data-mamau="${sp.getMamau()}">${sp.getTenmau()}</td>
								<td class="size" data-masize="${sp.getMasize()}">${sp.getTensize()}</td>
								<td class="soluong"><input type="number"
									class="soluong-giohang" min="1" value="${sp.getSoluong()}"></td>
								<td class="giatien" data-giatien="${sp.getGiatien()}">${sp.getGiatien()}</td>
								<td><button class="xoagiohang btn btn-danger">Xoa</button></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<h4 style="text-align: center;">
					Tổng tiền : <span id="tongtien" style="color: red;">1,500,000
						VND</span>
				</h4>
			</div>
			<div class="col-md-4 col-sm-12">
				<h3>Thông tin người nhận/mua</h3>
				<div class="form-group">
					<form action="" method="post">
						<label for="tennguoimua">Tên người mua/nhận</label> <input
							class="form-control" type="text" id="tennguoimua" name="tenKhachHang"> <br>
						<label for="tennguoimua">Điện thoại liên lạc</label> <input
							class="form-control" type="text" id="sdt" name="sdt"> <br>
						<div class="radio">
							<label> <input type="radio" value="Giao hàng tận nơi" name="hinhthucgiaohang">
								Giao hàng tận nơi
							</label>
						</div>

						<div class="radio">
							<label> <input type="radio" value="Nhận hàng tại của hàng" name="hinhthucgiaohang"
								checked=""> Nhận hàng tại của hàng
							</label>
						</div>
						<br> <label for="diachi">Địa chỉ nhận hàng</label> <input
							class="form-control" type="text" id="diachi" name="diachigiahang"> <br> <label
							for="ghichu">Ghi chú:</label>
						<textarea class="form-control" rows="5" id="ghichu" name="ghichu"></textarea>
						<br> <input type="submit" class="btn btn-success"
							value="Đặt Hàng">
					</form>
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