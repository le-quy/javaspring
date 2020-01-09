<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="sanphamAPI" value="/api/sanpham" />
<c:url var="sanphamURL" value="/quan-tri/bai-viet/san-pham"></c:url>
<c:url var="editSanphamURL" value="/quan-tri/bai-viet/editsan-pham"></c:url>
<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li class="active">Chỉnh sửa bài viết</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content"></div>
			<div class="row">
				<div class="col-xs-12">
				<c:if test="${not empty message}">
						<div class="alert alert-${alert}">
  							${message}
						</div>
					</c:if>
					<!-- PAGE CONTENT BEGINS -->
					<form:form class="form-horizontal" role="form" id="formSubmit"
						modelAttribute="model">
						
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="tenmon"> Tên món </label>

							<div class="col-sm-9">
								<form:input path="tenMon" cssClass="col-xs-10 col-sm-5" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="dongia"> Đơn giá </label>
							<div class="col-sm-9">
								<form:input path="donGia" cssClass="col-xs-10 col-sm-5" />
							</div>	
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="phanloai"> Phân loại </label>
							<div class="col-sm-9">
								<form:input path="phanLoai" cssClass="col-xs-10 col-sm-5" />
							</div>	
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="hinhanh"> Đường dẫn hình ảnh </label>
							<div class="col-sm-9">
								<form:input path="hinhAnh" cssClass="col-xs-10 col-sm-5" />
							</div>	
						</div>
						
						<form:hidden path="id" id="newId" />
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<c:if test="${not empty model.id }">
									<button class="btn btn-info" type="button"
										id="btnAddOrUpdateNew">
										<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật bài viết
									</button>
								</c:if>
								<c:if test="${empty model.id }">
									<button class="btn btn-info" type="button"
										id="btnAddOrUpdateNew">
										<i class="ace-icon fa fa-check bigger-110"></i> Thêm bài viết
									</button>
								</c:if>
								&nbsp; &nbsp; &nbsp;
								<button class="btn" type="reset">
									<i class="ace-icon fa fa-undo bigger-110"></i> Hủy
								</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#btnAddOrUpdateNew').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			var id = $('#newId').val();
			if (id == "") {
				addNew(data);
			} else {
				updateNew(data);
			}
		});
		 

		function addNew(data) {
			$.ajax({
				url : '${sanphamAPI}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${editSanphamURL}?id="+result.id+"&message=insert_success ";
				},
				error : function(error) {
					window.location.href = "${sanphamURL}?page=1&limit=2&message=error_system";
				}
			});
		}

		function updateNew(data) {
			$.ajax({
				url : '${sanphamAPI}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${editSanphamURL}?id="+result.id+"&message=update_success";
				},
				error : function(error) {
					window.location.href = "${editSanphamURL}?id="+result.id+"&message=error_system";
				}
			});
		}
	</script>
</body>
</html>
