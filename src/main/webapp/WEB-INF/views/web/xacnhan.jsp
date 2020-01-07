<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:url var="newAPI" value="/api/new"/>
<c:url var="newURL" value="/san-pham"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách món</title>
	</head>

	<body>
		<div class="main-content">
		<form action="<c:url value='/san-pham'/>" id="formSubmit" method="get">		
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
													</tr>
												</thead>
												<tbody>
													
														<tr>
															<td width="120px"> <img alt="" width="100px" height="100px" src="${model.hinhAnh} "> </td>
															<td><h4>${model.tenMon}</h4></td>
															<td width="100px">
															<input type="number" id="soluong" min="1" max="10" value="${soluong}">  
															</td>
															<td><h4>${model.donGia} VNĐ</h4></td>
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
																	<i class="ace-icon fa fa-check bigger-110"></i> Xác nhận
																	</button>
															</td>
														</tr>
												
												</tbody>
											</table>		
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
			
			function warningBeforeDelete(){
				swal({
					  title: "Xác nhận xóa",
					  text: "Bạn có chắc chắn muốn xóa hay không",
					  type: "warning",
					  showCancelButton: true,
					  confirmButtonClass: "btn-success",
					  cancelButtonClass: "btn-danger",
					  confirmButtonText: "Xác nhận",
					  cancelButtonText: "Hủy bỏ",
					}).then(function(isConfirm) {
					  if (isConfirm) {
							var ids = $('tbody input[type=checkbox]:checked').map(function () {
					            return $(this).val();
					        }).get();
							deleteNew(ids);
					  }
					});
			}
			
			
			function deleteNew(data) {
		        $.ajax({
		            url: '${newAPI}',
		            type: 'DELETE',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            success: function (result) {
		                window.location.href = "${newURL}?page=1&limit=2&message=delete_success";
		            },
		            error: function (error) {
		            	window.location.href = "${newURL}?page=1&limit=2&message=error_system";
		            }
		        });
		    }
			
			function addMon(data) {
				$.ajax({
					url : '${newAPI}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "${editNewURL}?id="+result.id+"&message=insert_success ";
					},
					error : function(error) {
						window.location.href = "${newURL}?page=1&limit=2&message=error_system";
					}
				});
			}

		</script>
	</body>
	</html>