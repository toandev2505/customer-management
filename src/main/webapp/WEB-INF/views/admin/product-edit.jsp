<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="productAPI" value="/api/admin/product" />

<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>Quản lý bất động sản</title>
    <link href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet" type="text/css">
    <link href="<c:url value='/template/admin/css/sb-admin-2.min.css' />" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />
</head>

<body id="page-top">
    <div id="wrapper">
        <%@ include file="/common/admin/sidebar.jsp" %>
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <%@ include file="/common/admin/header.jsp" %>

                <div class="container-fluid">
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">${not empty model.id ? 'Cập nhật sản phẩm' : 'Thêm mới sản phẩm'}</h1>
                    </div>

                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}" role="alert">${message}</div>
                    </c:if>

                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <form:form class="form-horizontal" id="formSubmit" modelAttribute="model">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="font-weight-bold">Tiêu đề <span class="text-danger">*</span>:</label>
                                            <form:input type="text" id="title" class="form-control" path="title" required="required" />
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="font-weight-bold">Tỉnh/Thành phố:</label>
                                                    <form:select id="provinceSelect" path="provinceId" class="form-control">
                                                        <form:option value="">-- Chọn tỉnh --</form:option>
                                                        <form:options items="${provinces}" itemValue="id" itemLabel="name" />
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="font-weight-bold">Quận/Huyện:</label>
                                                    <form:select path="wardId" id="wardSelect" class="form-control">
                                                        <form:option value="">-- Chọn quận --</form:option>
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="font-weight-bold">Địa chỉ chi tiết:</label>
                                            <form:input type="text" class="form-control" path="address" />
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="font-weight-bold">Loại sản phẩm:</label>
                                                    <form:select path="type" class="form-control">
                                                        <form:option value="" label="-- Chọn loại --"/>
                                                        <form:options items="${types}" />
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="font-weight-bold">Hướng:</label>
                                                    <form:select path="direction" class="form-control">
                                                        <form:option value="" label="-- Chọn hướng --"/>
                                                        <form:options items="${directions}" />
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="font-weight-bold">Giá (VNĐ):</label>
                                                    <form:input type="number" path="price" class="form-control" />
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="font-weight-bold">Diện tích (m²):</label>
                                                    <form:input type="number" path="area" class="form-control" step="0.1" value="${model.area}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="font-weight-bold">Số phòng ngủ:</label>
                                            <form:input type="number" path="bedrooms" class="form-control" value="${model.bedrooms}" />
                                        </div>
                                        <div class="form-group">
                                            <label class="font-weight-bold">Hình ảnh đại diện:</label>
                                            <div class="custom-file">
                                                <form:input type="file" path="imageFile" class="custom-file-input" id="imageInput" />
                                                <label class="custom-file-label">Chọn ảnh...</label>
                                            </div>
                                            <div class="mt-3 text-center border p-2">
                                                <c:set var="imageSrc" value="${not empty model.base64Image ? model.base64Image : 'https://via.placeholder.com/250x150'}" />
                                                <img id="preview" src="${imageSrc}" style="max-height: 180px; max-width: 100%;">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <form:input type="hidden" path="id" id="productId" />

                                <div class="mt-4 border-top pt-3 text-right">
                                    <c:if test="${not empty model.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateProduct">
                                            <i class="fas fa-save"></i> Update Product
                                        </button>
                                    </c:if>
                                    <c:if test="${empty model.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateProduct">
                                            <i class="fas fa-save"></i> Insert Product
                                        </button>
                                    </c:if>
                                    <a href="<c:url value='/admin/product'/>" class="btn btn-secondary">Quay lại</a>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <%@ include file="/common/admin/footer.jsp" %>
        </div>
    </div>

    <script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
    <script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
    <script src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js' />"></script>

    <script>
        $(document).ready(function() {
            var currentWardId = "${model.wardId}";

            setTimeout(function() {
                var selectedProvinceId = $('#provinceSelect').val();
                console.log("Province ID hiện tại: " + selectedProvinceId);

                if (selectedProvinceId) {
                    loadWards(selectedProvinceId, currentWardId);
                }
            }, 100);

            $('#provinceSelect').change(function() {
                loadWards($(this).val(), null);
            });

            function loadWards(provinceId, selectedWardId) {
                if (!provinceId) return;

                var wardSelect = $('#wardSelect');
                $.ajax({
                    url: '${pageContext.request.contextPath}/api/ward?provinceId=' + provinceId,
                    type: 'GET',
                    success: function(res) {
                        wardSelect.empty().append('<option value="">-- Chọn quận --</option>');
                        $.each(res, function(i, item) {
                            var isSelected = (selectedWardId && item.id == selectedWardId) ? 'selected' : '';
                            wardSelect.append('<option value="' + item.id + '" ' + isSelected + '>' + item.name + '</option>');
                        });
                        console.log("Đã load xong " + res.length + " quận/huyện");
                    },
                    error: function() {
                        console.error("Không gọi được API /api/ward");
                    }
                });
            }
        });

        $("#imageInput").change(function(){
            var fileName = $(this).val().split("\\").pop();
            $(this).siblings(".custom-file-label").html(fileName);
            if (this.files && this.files[0]) {
                var reader = new FileReader();
                reader.onload = (e) => $('#preview').attr('src', e.target.result);
                reader.readAsDataURL(this.files[0]);
            }
        });

        $('#btnAddOrUpdateProduct').click(function (e) {
            e.preventDefault();

            // Lấy dữ liệu form
            var formData = new FormData($('#formSubmit')[0]);
            var id = $('#productId').val();
            var title = (id === "") ? "Xác nhận thêm mới" : "Xác nhận cập nhật";
            var text = (id === "") ? "Bạn có muốn thêm sản phẩm này không?" : "Bạn có muốn lưu các thay đổi không?";

            swal({
                title: title,
                text: text,
                type: "info",
                showCancelButton: true,
                confirmButtonClass: "btn-success",
                confirmButtonText: "Xác nhận",
                cancelButtonClass: "btn-danger",
                cancelButtonText: "Hủy bỏ",
                closeOnConfirm: false // Giữ lứa chọn để hiện loading nếu muốn
            }).then(function(isConfirm) {
                if (isConfirm) {
                    if (id === "") {
                        addProduct(formData);
                    } else {
                        updateProduct(formData);
                    }
                }
            });
        });

        function addProduct(data) {
            $.ajax({
                url: '${productAPI}',
                type: 'POST',
                enctype: 'multipart/form-data',
                processData: false,
                contentType: false,
                data: data,
                success: function(result) {
                    // Thông báo thành công xong mới redirect
                    swal("Thành công", "Dữ liệu đã được lưu!", "success").then(function() {
                        window.location.href = "${editProductURL}?id=" + result.id + "&message=insert_success";
                    });
                },
                error: function(error) {
                    swal("Lỗi", "Không thể lưu sản phẩm, vui lòng thử lại", "error");
                }
            });
        }

        function updateProduct(data) {
                    $.ajax({
                        url: '${productAPI}',
                        type: 'PUT',
                        enctype: 'multipart/form-data',
                        processData: false,
                        contentType: false,
                        data: data,
                        success: function(result) {
                            swal("Thành công", "Dữ liệu đã được lưu!", "success").then(function() {
                                window.location.href = "${editProductURL}?id=" + result.id + "&message=update_success";
                            });
                        },
                        error: function(error) {
                            swal("Lỗi", "Không thể lưu sản phẩm, vui lòng thử lại", "error");
                        }
                    });
                }
    </script>
</body>
</html>