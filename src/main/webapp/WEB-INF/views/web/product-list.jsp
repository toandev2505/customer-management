<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="customerRequestAPI" value="/api/customer/requirement" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm kiếm Bất động sản</title>
    <link href="<c:url value='/template/admin/css/sb-admin-2.min.css' />" rel="stylesheet">
    <style>
        .filter-section { background: #ffffff; padding: 25px; border-radius: 12px; margin-bottom: 30px; border: 1px solid #e3e6f0; }
        .property-card { transition: all 0.3s; border: none; box-shadow: 0 0.15rem 1.75rem 0 rgba(58, 59, 69, 0.15); border-radius: 10px; overflow: hidden; }
        .property-card:hover { transform: translateY(-8px); box-shadow: 0 0.5rem 2rem 0 rgba(58, 59, 69, 0.2); }
        .card-img-top { height: 200px; object-fit: cover; }
    </style>
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="text-gray-800 font-weight-bold">Tìm kiếm Bất động sản</h2>
    </div>

    <div class="filter-section shadow-sm">
        <form:form action="search-products" method="GET" modelAttribute="model" id="formSubmit">
            <input type="hidden" name="customerId" value="${param.customerId}">

            <div class="row g-3">
                <div class="col-md-3">
                    <label class="font-weight-bold text-dark">Loại hình</label>
                    <form:select path="type" class="form-control">
                        <form:option value="">Tất cả loại hình</form:option>
                        <form:options items="${types}" />
                    </form:select>
                </div>

                <div class="col-md-3">
                    <label class="font-weight-bold text-dark">Tỉnh/Thành phố</label>
                    <form:select id="provinceSelect" path="provinceId" class="form-control">
                        <form:option value="">-- Chọn tỉnh --</form:option>
                        <form:options items="${provinces}" itemValue="id" itemLabel="name" />
                    </form:select>
                </div>

                <div class="col-md-3">
                    <label class="font-weight-bold text-dark">Quận/Huyện</label>
                    <form:select path="wardId" id="wardSelect" class="form-control" multiple="true" size="3">
                    </form:select>
                    <small class="text-muted italic">Giữ Ctrl để chọn nhiều</small>
                </div>

                <div class="col-md-3">
                    <label class="font-weight-bold text-dark">Giá từ - đến (Tỷ)</label>
                    <div class="input-group">
                        <form:input path="" type="number" class="form-control" placeholder="Từ" />
                        <form:input path="" type="number" class="form-control" placeholder="Đến" />
                    </div>
                </div>
            </div>

            <div class="row mt-4 align-items-center">
                <button type="submit" class="btn btn-primary btn-block shadow-sm">
                    <i class="fas fa-search fa-sm"></i> Lọc & Tìm kiếm
                </button>
            </div>
        </form:form>
    </div>

    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-md-4 mb-4">
                <div class="card property-card h-100">
                    <div class="position-relative">
                        <c:set var="defaultImage" value="${pageContext.request.contextPath}/template/admin/img/default-image.jpg" />
                        <c:set var="imageSrc" value="${not empty product.base64Image ? product.base64Image : defaultImage}" />
                        <img src="${imageSrc}" class="card-img-top" alt="${product.title}" onerror="this.src='${defaultImage}'">

                        <div class="position-absolute" style="top: 10px; right: 10px;">
                            <c:choose>
                                <c:when test="${product.status == 'AVAILABLE'}">
                                    <span class="badge badge-success">Sẵn sàng</span>
                                </c:when>
                                <c:when test="${product.status == 'DEPOSITED'}">
                                    <span class="badge badge-warning text-dark">Đã cọc</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge badge-danger">Đã bán</span>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

                    <div class="card-body">
                        <h5 class="card-title font-weight-bold text-primary text-truncate">${product.title}</h5>

                        <div class="text-dark mb-3" style="font-size: 0.9rem;">
                            <p class="mb-1 text-truncate">
                                <i class="fas fa-map-marker-alt text-danger mr-2"></i>${product.address}
                            </p>
                            <p class="mb-1 text-truncate">
                                <i class="fas fa-map-marker-alt text-danger mr-2"></i>${product.wardName}, ${product.districtName}
                            </p>

                            <div class="row no-gutters mt-2">
                                <div class="col-6">
                                    <i class="fas fa-tag text-success mr-1"></i><strong>${product.price} VNĐ</strong>
                                </div>
                                <div class="col-6">
                                    <i class="fas fa-expand text-info mr-1"></i><strong>${product.area} m²</strong>
                                </div>
                            </div>

                            <div class="row no-gutters mt-2">
                                <div class="col-6">
                                    <i class="fas fa-bed text-warning mr-1"></i>${product.bedrooms} PN
                                </div>
                                <div class="col-6">
                                    <i class="fas fa-compass text-secondary mr-1"></i>Hướng: ${product.direction}
                                </div>
                            </div>
                        </div>

                        <a href="<c:url value='/product/detail?id=${product.id}'/>" class="btn btn-primary btn-sm btn-block shadow-sm">
                            Xem chi tiết
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
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
</script>
</body>
</html>