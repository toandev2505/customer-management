<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="productAPI" value="/api/admin/product" />
<c:url var="editProductURL" value="/admin/product/edit" />

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
                            <form id="formSubmit">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="font-weight-bold">Tiêu đề <span class="text-danger">*</span>:</label>
                                            <input type="text" name="title" id="title" class="form-control" value="${model.title}" required>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="font-weight-bold">Tỉnh/Thành phố:</label>
                                                    <select id="provinceSelect" class="form-control">
                                                        <option value="">-- Chọn tỉnh --</option>
                                                        <c:forEach var="item" items="${provinces}">
                                                            <option value="${item.id}" ${item.name == model.provinceName ? 'selected' : ''}>
                                                                ${item.name}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="font-weight-bold">Quận/Huyện:</label>
                                                    <select name="wardId" id="wardSelect" class="form-control">
                                                        <option value="">-- Chọn quận --</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="font-weight-bold">Địa chỉ chi tiết:</label>
                                            <input type="text" name="address" class="form-control" value="${model.address}">
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="font-weight-bold">Loại sản phẩm:</label>
                                                    <select name="type" class="form-control">
                                                        <c:forEach var="item" items="${types}">
                                                            <option value="${item}" ${item == model.type ? 'selected' : ''}>${item}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="font-weight-bold">Hướng:</label>
                                                    <select name="direction" class="form-control">
                                                        <c:forEach var="item" items="${directions}">
                                                            <option value="${item}" ${item == model.direction ? 'selected' : ''}>${item}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="font-weight-bold">Giá (VNĐ):</label>
                                                    <input type="number" name="price" class="form-control" value="${model.price}">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="font-weight-bold">Diện tích (m²):</label>
                                                    <input type="number" name="area" class="form-control" step="0.1" value="${model.area}">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="font-weight-bold">Số phòng ngủ:</label>
                                            <input type="number" name="bedrooms" class="form-control" value="${model.bedrooms}">
                                        </div>
                                        <div class="form-group">
                                            <label class="font-weight-bold">Hình ảnh đại diện:</label>
                                            <div class="custom-file">
                                                <input type="file" name="imageFile" class="custom-file-input" id="imageInput">
                                                <label class="custom-file-label">Chọn ảnh...</label>
                                            </div>
                                            <div class="mt-3 text-center border p-2">
                                                <c:set var="imageSrc" value="${not empty model.base64Image ? model.base64Image : 'https://via.placeholder.com/250x150'}" />
                                                <img id="preview" src="${imageSrc}" style="max-height: 180px; max-width: 100%;">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <input type="hidden" name="id" id="productId" value="${model.id}">

                                <div class="mt-4 border-top pt-3 text-right">
                                    <button type="button" class="btn btn-primary" id="btnAddOrUpdateProduct">
                                        <i class="fas fa-save"></i> Lưu dữ liệu
                                    </button>
                                    <a href="<c:url value='/admin/product'/>" class="btn btn-secondary">Quay lại</a>
                                </div>
                            </form>
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

            // Dùng swal giống hệt hàm xóa của bạn
            swal({
                title: title,
                text: text,
                type: "info", // Hiện icon dấu chấm hỏi/thông tin
                showCancelButton: true,
                confirmButtonClass: "btn-success",
                confirmButtonText: "Xác nhận",
                cancelButtonClass: "btn-danger",
                cancelButtonText: "Hủy bỏ",
                closeOnConfirm: false // Giữ lứa chọn để hiện loading nếu muốn
            }).then(function(isConfirm) {
                if (isConfirm) {
                    // Nếu người dùng nhấn Xác nhận, gọi hàm Ajax
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

        // Hàm updateProduct tương tự như addProduct nhưng dùng type: 'PUT'
    </script>
</body>
</html>