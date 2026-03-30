<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${product.title} - Chi tiết</title>
    <link href="<c:url value='/template/admin/css/sb-admin-2.min.css' />" rel="stylesheet">
    <style>
        .detail-card { border-radius: 15px; border: none; overflow: hidden; }
        .main-img { width: 100%; height: 450px; object-fit: cover; border-radius: 10px; }
        .info-label { color: #858796; font-size: 0.9rem; margin-bottom: 2px; }
        .info-value { font-weight: 700; color: #4e73df; font-size: 1.1rem; }
        .price-tag { font-size: 2rem; color: #e74a3b; font-weight: 800; }
    </style>
</head>
<body class="bg-light">

<div class="container mt-5 mb-5">
    <a href="<c:url value='/product' />" class="btn btn-outline-secondary mb-4 shadow-sm">
        <i class="fas fa-arrow-left"></i> Quay lại danh sách
    </a>

    <div class="row">
        <div class="col-lg-7 mb-4">
            <div class="card detail-card shadow">
                <c:set var="defaultImg" value="${pageContext.request.contextPath}/template/admin/img/default-image.jpg" />
                <img src="${not empty product.base64Image ? product.base64Image : defaultImg}"
                     class="main-img" alt="${product.title}" onerror="this.src='${defaultImg}'">
            </div>
        </div>

        <div class="col-lg-5">
            <div class="card detail-card shadow p-4 h-100">
                <div class="mb-3">
                    <span class="badge badge-primary px-3 py-2">${product.type}</span>
                    <span class="badge badge-success px-3 py-2">${product.status}</span>
                </div>

                <h2 class="font-weight-bold text-gray-800">${product.title}</h2>
                <p class="text-muted"><i class="fas fa-map-marker-alt text-danger"></i> ${product.address}, ${product.wardName}, ${product.provinceName}</p>

                <hr>

                <div class="price-tag mb-4">${product.price} VNĐ</div>

                <div class="row text-center mb-4">
                    <div class="col-4 border-right">
                        <div class="info-label">Diện tích</div>
                        <div class="info-value">${product.area} m²</div>
                    </div>
                    <div class="col-4 border-right">
                        <div class="info-label">Phòng ngủ</div>
                        <div class="info-value">${product.bedrooms}</div>
                    </div>
                    <div class="col-4">
                        <div class="info-label">Hướng</div>
                        <div class="info-value">${product.direction}</div>
                    </div>
                </div>

                <button class="btn btn-danger btn-lg btn-block shadow-sm font-weight-bold">
                    LIÊN HỆ NGAY
                </button>
            </div>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-12">
            <div class="card detail-card shadow p-4">
                <h4 class="font-weight-bold text-primary border-bottom pb-2">Thông tin mô tả</h4>
                <div class="mt-3 text-dark leading-relaxed">
                    ${product.title}. Bất động sản tại ${product.address} với đầy đủ tiện ích xung quanh,
                    diện tích ${product.area} m², hướng ${product.direction}.
                    Liên hệ để biết thêm chi tiết.
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
</body>
</html>