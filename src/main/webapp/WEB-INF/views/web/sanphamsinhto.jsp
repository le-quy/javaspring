<%@ page import="com.laptrinhjavaweb.util.SecurityUtils" %>
<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:url var="newAPI" value="/api/new"/>
<c:url var="newURL" value="/sinh-to"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách món</title>
	</head>

	<body>
		<div class="main-content">
		<form action="<c:url value='/sinh-to'/>" id="formSubmit" method="get">	
			<CENTER>
			<div style="margin-top: 20px">
				<h3><a> DOANH MỤC : </a> </h3>
		        <a style="margin-left: 20px" class="btn btn-primary" href="/ca-phe?page=1&limit=5">CÀ PHÊ</a>
		
		        <a style="margin-left: 20px" class="btn btn-primary" href="/tra?page=1&limit=5">TRÀ TRÁI CÂY </a>
 				
 				<a style="margin-left: 20px" class="btn btn-primary" href="/da-xay?page=1&limit=5">ĐÁ XAY </a>
		        
		        <a style="margin-left: 20px" class="btn btn-primary" href="/sinh-to?page=1&limit=5">SINH TỐ</a>
			</div>
			</CENTER>	
				<div class="main-content-inner">
					
					<div class="page-content">
						<div class="row">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">
	  							${message}
							</div>
						</c:if>
							<div class="col-xs-12">
								<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
										</div>
									</div>
								</div>
								<center> 
								<lable for="table"> <h3> <a style="font-family: arial"> SINH TỐ  </a> </h3> </lable>
								</center>
								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">		
											<table class="table table-bordered"  >
												<thead>
													<tr >
														<th style="text-align:center"><h4>Hình ảnh</h4></th>
												 		<th style="text-align:center"><h4>Tên món</h4></th>
														<th style="text-align:center"><h4>Đơn giá</h4></th>
														<th style="text-align:center"><h4>Đặt món</h4></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${model.listResult}">
														<tr>
															<td width="120px"> <img alt="" width="100px" height="100px" src="${item.hinhAnh} "> </td>
															<td><h4>${item.tenMon}</h4></td>
															<td><h4>${item.donGia} VNĐ</h4></td>
															<td width="100px">
																 	<c:url var="xacNhanMonURL" value="/xac-nhan">
																	<c:param name="id" value = "${item.id}"></c:param>
																	</c:url>
																	<security:authorize access="isAnonymous()">
																		<a class="btn btn-primary"
																   	title="Đăng nhập" href='/dang-nhap'> đăng nhập để đặt món
																	</a>
																	</security:authorize>
																	<security:authorize access="isAuthenticated()">	
																	<a class="btn btn-primary"
																   		title="Đặt món" href='${xacNhanMonURL}'> Đặt món
																		</a></security:authorize>
															</td>
														</tr>
													</c:forEach>
												</tbody> 
											</table>		
											<center>
											<ul class="pagination" id="pagination"></ul>
											</center>		
											<input type="hidden" value="" id="page" name="page"/>
											<input type="hidden" value="" id="limit" name="limit"/>										
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</form>
		</div>
		<!-- /.main-content -->
		<script>
			var totalPages = ${model.totalPage};
			var currentPage = ${model.page};
			$(function () {
		        window.pagObj = $('#pagination').twbsPagination({
		            totalPages: totalPages,
		            visiblePages: 10,
		            startPage: currentPage,
		            onPageClick: function (event, page) {
		            	if (currentPage != page) {
		            		$('#limit').val(5);
							$('#page').val(page);
							$('#formSubmit').submit();
						}
		            }
		        });
		    });
			 
		</script>
	</body>
	</html>