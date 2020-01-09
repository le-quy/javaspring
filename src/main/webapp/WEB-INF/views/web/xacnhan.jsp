<%@ page import="com.laptrinhjavaweb.util.SecurityUtils" %>
<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:url var="orderAPI" value="/api/order"/>
<c:url var="monURL" value="/san-pham"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách món</title>
	</head>

	<body>
		<div class="main-content">
		<form action="<c:url value='/xac-nhan'/>" id="formSubmit" method="get">		
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						
					</div>
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
								<lable for="table"> <h3> <a style="font-family: arial"> ĐẶT MÓN </a> </h3> </lable>
								</center>
								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">		
											<table class="table table-bordered"  >
												<thead>
													<tr >
														<th style="text-align:center"><h4>Hình ảnh</h4></th>
												 		<th style="text-align:center"><h4>Tên món</h4></th>
														<th style="text-align:center"><h4>Số lượng</h4></th>
														<th style="text-align:center"><h4>Đơn giá</h4></th>
														<th style="text-align:center"><h4>Ghi chú</h4></th>
													</tr>
												</thead>
												<tbody>
													
														<tr>
															<td width="120px"> <img alt="" width="100px" height="100px" src="${model.hinhAnh} "> </td>
															<td><h4>${model.tenMon}</h4></td>
															<td width="100px">
															<input type="number" path="soLuong" min="1" max="10" value="${soluong}"/>  
															</td>
															<td><h4> ${model.donGia} VNĐ</h4></td>
															<td width="200px"><textarea rows="5" cols="40" id="ghichu" ></textarea></td>
															<td width="50px">
															<%--<c:url var="updateNewURL" value="/quan-tri/bai-viet/chinh-sua">
																<c:param name="id" value = "${item.id}"></c:param>
															</c:url>																
																<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																   title="Cập nhật bài viết" href='${updateNewURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																</a>
																 --%>
																 <button class="btn btn-info" type="button"
																	id="btndatmon">
																	<i class="ace-icon fa fa-check bigger-110"></i> Thêm vào giỏ 
																	</button>
																	<br/>															
																	 <button style="margin-top: 10px" class="btn btn-info" type="button"
																	id="btntrolai">
																	<i class="ace-icon fa fa-check bigger-110"></i> Trở lại
																	</button>
															</td>
														</tr>
												
												</tbody>
											</table>
											<input type="hidden" value="<%=SecurityUtils.getPrincipal().getUsername() %>" id="username" />		
											<input type="hidden" value= "11"  id="thanhtien" />
											<input type="hidden" value="${model.id}" id="idmon" name="idmon"/>
											<center>
										
											</center>		
													
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
		
			$('#btntrolai').click(function redirect(){ 	
					window.location.href = "${monURL}?page=1&limit=5";
			});
			
			$('#btndatmon').click(function(e) {
				e.preventDefault();
				var data = {};
				var formData = new FormData();
				var username = $('#username').val();		
				var idmon = ${model.id};
				var soluong = $('#soluong').val();
				var thanhtien = parseInt(soluong) * ${model.donGia};
				
				formData.append('username', username);
				formData.append('idmon', parseInt(idmon) );
				formData.append('soluong', parseInt(soluong));
				formData.append('thanhtien', parseInt(thanhtien)); 
				
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				
				addOrder(data);
			});
			
			
			function addOrder(data) {
				$.ajax({
					url : '${orderAPI}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "${monURL}?page=1&limit=5&message=insert_success ";
					},
					error : function(error) {
						window.location.href = "${monURL}?page=1&limit=5&message=error_system";
					}
				});
			}

		</script>
	</body>
	</html>