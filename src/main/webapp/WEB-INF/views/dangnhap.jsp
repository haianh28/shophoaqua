<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<meta charset="UTF-8">
<title>ĐĂNG NHẬP</title>
</head>
<body id="body-login">
	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
				<div id="header-top-left" class="header-login">
					<span id="text-login">WELLCOME</span><br> <span
						id="hint-text-login">Phần Mền chất lượng cao</span>
				</div>
				<div id="header-bottom-left">
					<p>
						<img alt="icon_oval"
							src='<c:out value="resource/Image/tick.png"/>'> <span>Phần
							mềm được sử dụng rộng rãi</span>
					</p>
					<p>
						<img alt="icon_oval"
							src='<c:out value="resource/Image/tick.png"/>'> <span>Giảm
							20% khi mua bản quyền sử dụng 1 năm</span>
					</p>
					<p>
						<img alt="icon_oval"
							src='<c:out value="resource/Image/tick.png"/>'> <span>Cam
							kết chất lượng đúng như Quý khách mong đợi</span>
					</p>

				</div>
			</div>
			<div id="container-login-right">
				<div id="header-top-right" class="header-login">
					<span class="actived" id="dangnhap" >Đăng Nhập</span> / <span id="dangky" >Đăng Ký</span>
				</div>
				<span>${kiemtradangnhap}</span>
				<div id="container-center-login-right">
	<div class="container-login-form">
	<input class="material-textinput input-icon-email" id="email" name="email" placeholder="EMail" type="text" /><br> <p></p>
	<input class="material-textinput input-icon-password" id="matkhau" name="matkhau" placeholder="Mật Khẩu" type="password" /><br> 
	<input class="material-primary-button" type="submit" id="btndangnhap" value="Đăng Nhập" />
	</div>
	
	<div class="container-singup-form">
	<form action="" method="post">	
	<span>${CheckSingUp}</span>
	<input class="material-textinput input-icon-email" id="email" name="email" placeholder="EMail" type="text" /><br> <p></p>
	<input class="material-textinput input-icon-password" id="matkhau" name="matkhau" placeholder="Mật Khẩu" type="password" /><br> <p></p>
	<input class="material-textinput input-icon-password" id="nhaplaimatkhau" name="nhaplaimatkhau" placeholder="Nhập Lại Mật Khẩu" type="password" /><br> 
	<input class="material-primary-button" type="submit" id="btndangky" value="Đăng Ký" />
	</form>
	</div>
				</div>
				<span id="btnketqua"></span>
				<div id="container-social-login">
					<img alt="icon_facebook"
						src='<c:out value="resource/Image/facebook.png"/>'> <img
						alt="icon_facebook"
						src='<c:out value="resource/Image/google.png"/>'>

				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>