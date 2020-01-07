<%@ page import="com.laptrinhjavaweb.util.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="/trang-chu">Happy Life</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active">
				<h4><a class="nav-link" href="<c:url value ='/trang-chu'/>">Trang chủ <span class="sr-only">(current)</span>
				</a></h4>
				</li>
				<li class="nav-item"><h4><a class="nav-link" href="<c:url value ='/san-pham?page=1&limit=5'/>"> Menu </a> </h4>		
				</li>
				</li>
				<security:authorize access="isAnonymous()">
					<li class="nav-item"><h4> <a class="nav-link" href="<c:url value ='/dang-nhap'/>">Đăng nhập</a></h4>
					</li>
					<li class="nav-item"> <h4> <a class="nav-link" href="#">Đăng kí</a></h4>
					</li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li class="nav-item"><h4> <a class="nav-link" href="#"><%=SecurityUtils.getPrincipal().getFullName() %></a> </h4>
					
					</li>
					<li class="nav-item"> <h4><a class="nav-link" href="<c:url value ='/thoat'/>">Thoát</a></li></h4>
					</li>
				</security:authorize>
				<li class="nav-item"><h4><a class="nav-link" href="#">Giỏ hàng</a></h4>
			</ul>
		</div>
	</div>
</nav>