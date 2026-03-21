<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<c:url var="productAPI" value="/api/admin/product" />
<c:url var="editProductURL" value="/admin/product/edit" />

<html>
<head>
    <title>Quản lý sản phẩm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">${not empty model.id ? 'Cập nhật sản phẩm' : 'Thêm mới sản phẩm'}</h2>

    <form id="formSubmit">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label>Tiêu đề:</label>
                    <input type="text" name="title" id="title" class="form-control" value="${model.title}" required>
                </div>

                <div class="form-group">
                    <label>Địa chỉ:</label>
                    <input type="text" name="address" id="address" class="form-control" value="${model.address}">
                </div>

                <div class="form-group">
                    <label>Loại sản phẩm:</label>
                    <select name="type" class="form-control">
                        <option value="">-- Chọn loại --</option>
                        <c:forEach var="item" items="${types}">
                            <option value="${item}" ${item == model.type ? 'selected' : ''}>${item}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label>Quận:</label>
                    <select name="wardId" class="form-control">
                        <option value="">-- Chọn quận --</option>
                        <c:forEach var="item" items="${wards}">
                            <option value="${item.id}" ${item == model.wardId ? 'selected' : ''}>${item.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label>Giá (VNĐ):</label>
                    <input type="number" name="price" class="form-control" step="0.01" value="${model.price}">
                </div>

                <div class="form-group">
                    <label>Diện tích (m²):</label>
                    <input type="number" name="area" class="form-control" step="0.1" value="${model.area}">
                </div>
            </div>

            <div class="col-md-6">
                <div class="form-group">
                    <label>Hướng:</label>
                    <select name="direction" class="form-control">
                        <option value="">-- Chọn hướng --</option>
                        <c:forEach var="item" items="${directions}">
                            <option value="${item}" ${item == model.direction ? 'selected' : ''}>${item}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label>Số phòng ngủ:</label>
                    <input type="number" name="bedrooms" class="form-control" value="${model.bedrooms}">
                </div>

                <div class="form-group">
                    <label>Hình ảnh sản phẩm:</label>
                    <input type="file" name="imageFile" class="form-control-file" id="imageInput">
                    <div class="mt-2">
                        <c:set var="imageSrc" value="${not empty model.base64Image ? model.base64Image : '#'}" />
                        <img id="preview" src="${imageSrc}" alt="Preview"
                             style="${not empty model.base64Image ? '' : 'display:none;'} width: 150px; border: 1px solid #ddd;">
                    </div>
                </div>
            </div>
        </div>

        <input type="hidden" name="id" id="productId" value="${model.id}">

        <button type="button" class="btn btn-success" id="btnAddOrUpdateProduct">Lưu sản phẩm</button>
        <a href="<c:url value='/admin/product'/>" class="btn btn-secondary">Hủy</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.js"></script>

<script>
    // 1. Xử lý Preview ảnh khi chọn file
    $("#imageInput").change(function(){
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#preview').attr('src', e.target.result).show();
            }
            reader.readAsDataURL(this.files[0]);
        }
    });

    // 2. Xử lý Click nút Submit
    $('#btnAddOrUpdateProduct').click(function(e) {
        e.preventDefault();

        var formData = new FormData($('#formSubmit')[0]);

        if ($('#title').val().trim() === "") {
            swal("Lỗi!", "Tiêu đề không được để trống", "error");
            return;
        }

        var id = $('#productId').val();
        if (id == "") {
            addProduct(formData);
        } else {
            updateProduct(formData);
        }
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
                swal("Thành công!", "Thêm mới sản phẩm thành công", "success");
                setTimeout(function(){
                    window.location.href = "${editProductURL}?id=" + result.id + "&message=insert_success";
                }, 1500);
            },
            error: function(result) {
                swal("Lỗi!", "Không thể thêm sản phẩm", "error");
            }
        });
    }
</script>
</body>
</html>