<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Pooled Admin Panel Category Flat Bootstrap Responsive Web
	Template | Home :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href='<c:out value="${pageContext.request.contextPath}/resource/Css/bootstrap.min.css"/>'>
<!-- Custom CSS -->
<link rel="stylesheet"
	href='<c:out value="${pageContext.request.contextPath}/resource/Css/style.css"/>'>
<link rel="stylesheet"
	href='<c:out value="${pageContext.request.contextPath}/resource/Css/morris.css"/>'>
<!-- Graph CSS -->
<link rel="stylesheet"
	href='<c:out value="${pageContext.request.contextPath}/resource/Css/font-awesome.css"/>'>
<!-- jQuery -->
<script
	src='<c:out value="${pageContext.request.contextPath}/resource/JavaScript/jquery-3.4.1.min.js"/>'></script>
<!-- //jQuery -->
<link
	href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400'
	rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link rel="stylesheet"
	href='<c:out value="${pageContext.request.contextPath}/resource/Css/icon-font.min.css"/>'>
<!-- //lined-icons -->
</head>
<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="row">
			
				<h3 style="text-align: center;">SẢN PHẨM</h3>
				<form id="form-sanpham" action="">
				<div class="col-md-4 col-sm-12">
				<label for="tenSanPham" >Tên sản phẩm</label>
				<input id="tenSanPham" name="tenSanPham" class="form-control" placeholder="Nhập vào tên sản phẩm"><br>
				
				<label>Danh Mục</label>
				<select class="form-control" id="danhMucSanPham" name="danhMucSanPham">
				<c:forEach var="dm" items="${danhmuc}">
				
				<option value="${dm.getMaDanhMuc()}">${dm.getTenDanhMuc()}</option>
				
				</c:forEach>
				</select><br>
		
				<label for="giatien" >Giá tiền</label>
				<input id="giatien" name="giatien" class="form-control" placeholder="Nhập vào giá tiền"><br>
				
				<b/><span>Giành Cho</span><br>
				<label class="radio-inline">
				<input type="radio" id="rd-nam" name="gianhcho" value="nam">Nam
				</label>
				
				<label class="radio-inline">
				<input type="radio" id="rd-nu" name="gianhcho" value="nu">Nữ
				</label>
				<br>
				
				<br><label for="mota" >Mô tả</label>
				<textarea row="5" id="mota" name="mota" class="form-control" placeholder="Nhập vào mô tả"></textarea><br>
				
				<label for="hinhanhsp" >Hình ảnh</label>
				<input type="file" id="hinhSanPham"  name="hinhSanPham" class="form-control" placeholder="Chọn file hình ảnh"><br>
				
				<div id = "contenerchitietsanpham">
				<div class="chitietsanpham">
				<b/>
				<p>Chi Tiết</p>
				<!-- dau tien la hien thi phan chi tiet nhung xoa id bị none di -->
				<!-- mau  -->
						<select class="form-control" id="mausanpham"
							name="mausanpham">
							<c:forEach var="mau" items="${mau}">

								<option value="${mau.getMaMau()}">${mau.getTenMau()}</option>

							</c:forEach>
						</select><br>
						<!-- size -->
						<select class="form-control" id="sizesanpham"
							name="sizesanpham">
							<c:forEach var="size" items="${size}">

								<option value="${size.getMaSize()}">${size.getSize()}</option>

							</c:forEach>
						</select><br>
						<input type="number" min="0"  max="1000" name="soluong" id="soluong" value="1" class="form-control" placeholder="Chọn số lượng" ><br>
						<p><button class="btn btn-success btn-chitiet">Thêm Chi Tiết</button></p>
					</div>
				</div>
				
				<div id="chitietsanpham" class="chitietsanpham">
				<p>Chi Tiết</p>
				<!-- mau  -->
						<select class="form-control" id="mausanpham"
							name="mausanpham">
							<c:forEach var="mau" items="${mau}">

								<option value="${mau.getMaMau()}">${mau.getTenMau()}</option>

							</c:forEach>
						</select><br>
						<!-- size -->
						<select class="form-control" id="sizesanpham"
							name="sizesanpham">
							<c:forEach var="size" items="${size}">

								<option value="${size.getMaSize()}">${size.getSize()}</option>

							</c:forEach>
						</select><br>
						<input type="number" min="0"  max="1000" id="soluong" name="soluong" value="1" class="form-control" placeholder="Chọn số lượng" ><br>
						<p>
							<button class="btn btn-success btn-chitiet">Thêm Chi Tiết</button>
						</p>
					</div>
					<p>
					<button id="themsanpham" class="btn btn-success">Thêm Sản Phẩm</button>
					<button id="capnhat" class="btn btn-success hidden">Cập Nhật</button>
					<button id="thoat" class="btn btn-success hidden">Thoát</button>
					</p>
				</form>
				</div>

				<div class="col-md-8 col-sm-12">
					<div style="float: right;">
						<button id="xoasanpham" class="btn btn-warning">Xóa</button>
					</div>
					<table id="table-sanpham" class="table">
						<thead>
							<tr>
								<th><input id="check-all" type="checkbox" value="">
									ALL</th>
								<th>Tên Sản Phẩm</th>
								<th>Giá Tiền</th>
								<th>Giành Cho</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="sp" items="${listsp}">
								<tr>
									<td><input type="checkbox" value="${sp.getMaSanPham()}">
									</th>
									<td class="tensp" data-masp="${sp.getMaSanPham()}">${sp.getTenSanPham()}</td>
									<td class="giatien">${sp.getGiatien()}</td>
									<td class="gianhcho">${sp.getGianhcho()}</td>
									<td id="capnhatsanpham" class="btn btn-warning" data-capnhat="${sp.getMaSanPham()}">Sửa</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

					<div style="text-align: center;">
						<ul class="pagination pagination-sm" style="text-align: center;">
							<c:forEach var="i" begin="1" end="${sopage}">
								<c:choose>
									<c:when test="${i==1}">
										<li class="pagin-item active"><a href="#">${i}</a></li>
									</c:when>
									<c:otherwise>
										<li class="pagin-item"><a href="#">${i}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</div>
				</div>

			</div>

		</div>
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<div class="sidebar-menu">
			<header class="logo1">
				<a href="" class="sidebar-icon"> <span class="fa fa-bars"></span>
				</a>
			</header>
			<div style="border-top: 1px ridge rgba(255, 255, 255, 0.15)"></div>
			<div class="menu">
				<ul id="menu">
					<li><a
						href='<c:out value="${pageContext.request.contextPath}/Dashboard"/>'><i
							class="fa fa-tachometer"></i> <span>Dashboard</span>
						<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a
						href='<c:out value="${pageContext.request.contextPath}/ThemSanPham"/>'><i
							class="fa fa-product-hunt nav_icon"></i><span>Sản Phẩm</span>
						<div class="clearfix"></div></a></li>
					<li><a href="gallery.html"><i class="fa fa-picture-o"
							aria-hidden="true"></i><span>Gallery</span>
						<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="charts.html"><i
							class="fa fa-bar-chart"></i><span>Charts</span>
						<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i
							class="fa fa-list-ul" aria-hidden="true"></i><span> Short
								Codes</span> <span class="fa fa-angle-right" style="float: right"></span>
						<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="icons.html">Icons</a></li>
							<li id="menu-academico-avaliacoes"><a href="typography.html">Typography</a></li>
							<li id="menu-academico-avaliacoes"><a href="faq.html">Faq</a></li>
						</ul></li>
					<li id="menu-academico"><a href="errorpage.html"><i
							class="fa fa-exclamation-triangle" aria-hidden="true"></i><span>Error
								Page</span>
						<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i class="fa fa-cogs"
							aria-hidden="true"></i><span> UI Components</span> <span
							class="fa fa-angle-right" style="float: right"></span>
						<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="button.html">Buttons</a></li>
							<li id="menu-academico-avaliacoes"><a href="grid.html">Grids</a></li>
						</ul></li>
					<li><a href="tabels.html"><i class="fa fa-table"></i> <span>Tables</span>
						<div class="clearfix"></div></a></li>
					<li><a href="maps.html"><i class="fa fa-map-marker"
							aria-hidden="true"></i> <span>Maps</span>
						<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i
							class="fa fa-file-text-o"></i> <span>Pages</span> <span
							class="fa fa-angle-right" style="float: right"></span>
						<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-boletim"><a href="calendar.html">Calendar</a></li>
							<li id="menu-academico-avaliacoes"><a href="signin.html">Sign
									In</a></li>
							<li id="menu-academico-avaliacoes"><a href="signup.html">Sign
									Up</a></li>


						</ul></li>
					<li><a href="#"><i class="fa fa-check-square-o nav_icon"></i><span>Forms</span>
							<span class="fa fa-angle-right" style="float: right"></span>
						<div class="clearfix"></div></a>
						<ul>
							<li><a href="input.html"> Input</a></li>
							<li><a href="validation.html">Validation</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}

					toggle = !toggle;
				});
	</script>
<!--js -->
<script
		src='<c:out value="${pageContext.request.contextPath}/resource/JavaScript/jquery.nicescroll.js"/>'></script>
<script
		src='<c:out value="${pageContext.request.contextPath}/resource/JavaScript/scripts.js"/>'></script>
		
		<script src='<c:out value="${pageContext.request.contextPath}/resource/JavaScript/custom.js"/>'></script>
<!-- Bootstrap Core JavaScript -->
<script
		src='<c:out value="${pageContext.request.contextPath}/resource/JavaScript/bootstrap.min.js"/>'></script>
   <!-- /Bootstrap Core JavaScript -->	   
<!-- morris JavaScript -->	
<script
		src='<c:out value="${pageContext.request.contextPath}/resource/JavaScript/raphael-min.js"/>'></script>
<script
		src='<c:out value="${pageContext.request.contextPath}/resource/JavaScript/morris.js"/>'></script>
<script>
	$(document).ready(
			function() {
				//BOX BUTTON SHOW AND CLOSE
				jQuery('.small-graph-box').hover(function() {
					jQuery(this).find('.box-button').fadeIn('fast');
				}, function() {
					jQuery(this).find('.box-button').fadeOut('fast');
				});
				jQuery('.small-graph-box .box-close').click(function() {
					jQuery(this).closest('.small-graph-box').fadeOut(200);
					return false;
				});

				//CHARTS
				function gd(year, day, month) {
					return new Date(year, month - 1, day).getTime();
				}

				graphArea2 = Morris.Area({
					element : 'hero-area',
					padding : 10,
					behaveLikeLine : true,
					gridEnabled : false,
					gridLineColor : '#dddddd',
					axes : true,
					resize : true,
					smooth : true,
					pointSize : 0,
					lineWidth : 0,
					fillOpacity : 0.85,
					data : [ {
						period : '2014 Q1',
						iphone : 2668,
						ipad : null,
						itouch : 2649
					}, {
						period : '2014 Q2',
						iphone : 15780,
						ipad : 13799,
						itouch : 12051
					}, {
						period : '2014 Q3',
						iphone : 12920,
						ipad : 10975,
						itouch : 9910
					}, {
						period : '2014 Q4',
						iphone : 8770,
						ipad : 6600,
						itouch : 6695
					}, {
						period : '2015 Q1',
						iphone : 10820,
						ipad : 10924,
						itouch : 12300
					}, {
						period : '2015 Q2',
						iphone : 9680,
						ipad : 9010,
						itouch : 7891
					}, {
						period : '2015 Q3',
						iphone : 4830,
						ipad : 3805,
						itouch : 1598
					}, {
						period : '2015 Q4',
						iphone : 15083,
						ipad : 8977,
						itouch : 5185
					}, {
						period : '2016 Q1',
						iphone : 10697,
						ipad : 4470,
						itouch : 2038
					}, {
						period : '2016 Q2',
						iphone : 8442,
						ipad : 5723,
						itouch : 1801
					} ],
					lineColors : [ '#ff4a43', '#a2d200', '#22beef' ],
					xkey : 'period',
					redraw : true,
					ykeys : [ 'iphone', 'ipad', 'itouch' ],
					labels : [ 'All Visitors', 'Returning Visitors',
							'Unique Visitors' ],
					pointSize : 2,
					hideHover : 'auto',
					resize : true
				});

			});
</script>
</body>
</html>