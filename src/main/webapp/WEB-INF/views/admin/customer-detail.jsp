<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chi tiết khách hàng</title>
    <link href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet">
    <link href="<c:url value='/template/admin/css/sb-admin-2.min.css' />" rel="stylesheet">

    <style>
        .badge-ai-hot { background-color: #e74a3b; color: white; animation: pulse 2s infinite; }
        .badge-ai-warm { background-color: #f6c23e; color: white; }
        .badge-ai-cold { background-color: #858796; color: white; }
        @keyframes pulse {
            0% { transform: scale(1); }
            50% { transform: scale(1.05); }
            100% { transform: scale(1); }
        }
    </style>
</head>
<body id="page-top">
    <div id="wrapper">
        <%@ include file="/common/admin/sidebar.jsp" %>
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <%@ include file="/common/admin/header.jsp" %>

                <div class="container-fluid">
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Hồ sơ khách hàng: ${model.name}</h1>
                        <a href="<c:url value='/admin/customer-management'/>" class="btn btn-sm btn-secondary shadow-sm">
                            <i class="fas fa-arrow-left fa-sm text-white-50"></i> Quay lại
                        </a>
                    </div>

                    <div class="row">
                        <div class="col-xl-4 col-lg-5">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Thông tin cơ bản</h6>
                                </div>
                                <div class="card-body">
                                    <div class="text-center mb-3">
                                        <img class="img-profile rounded-circle" src="https://ui-avatars.com/api/?name=${model.name}&background=4e73df&color=fff&size=128" alt="avatar">
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item"><strong>Họ tên:</strong> ${model.name}</li>
                                        <li class="list-group-item"><strong>Điện thoại:</strong> ${model.phone}</li>
                                        <li class="list-group-item">
                                            <strong>Trạng thái:</strong>
                                            <span class="badge ${model.status == 1 ? 'badge-success' : 'badge-danger'}">
                                                ${model.status == 1 ? 'Đang hoạt động' : 'Ngừng theo dõi'}
                                            </span>
                                        </li>
                                    </ul>
                                    <div class="mt-3">
                                        <a href="<c:url value='/admin/customer-management/edit'/>" class="btn btn-primary btn-block">Chỉnh sửa thông tin</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-8 col-lg-7">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">Lịch sử nhu cầu tìm kiếm</h6>
                                    <a href="<c:url value='/admin/customer-management/requirement/edit'/>" class="btn btn-sm btn-success">
                                        <i class="fas fa-plus"></i> Thêm nhu cầu mới
                                    </a>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-hover">
                                            <thead class="thead-light">
                                                <tr>
                                                    <th>Loại BĐS</th>
                                                    <th>Khoảng giá (VNĐ)</th>
                                                    <th>Diện tích</th>
                                                    <th>Khu vực (Wards)</th>
                                                    <th>Ghi chú</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="req" items="${requirements}">
                                                    <tr>
                                                        <td><span class="badge badge-info">${req.propertyType}</span></td>
                                                        <td>${req.minPrice} - ${req.maxPrice}</td>
                                                        <td>${req.preferredArea} m²</td>
                                                        <td>
                                                            <c:forEach var="wardName" items="${req.wardNames}">
                                                                <span class="badge badge-light border">${wardName}</span>
                                                            </c:forEach>
                                                        </td>
                                                        <td><small class="text-muted">${req.note}</small></td>
                                                    </tr>
                                                </c:forEach>
                                                <c:if test="${empty requirements}">
                                                    <tr>
                                                        <td colspan="5" class="text-center">Chưa có dữ liệu nhu cầu cho khách hàng này.</td>
                                                    </tr>
                                                </c:if>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <div class="card shadow mb-4 border-left-primary">
                                <div class="card-header py-3 d-flex align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">
                                        <i class="fas fa-robot"></i> Bất động sản gợi ý bởi AI (Top Matching)
                                    </h6>
                                    <span class="badge badge-primary">Sắp xếp theo độ tương thích</span>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <c:forEach var="item" items="${recommendedProducts}">
                                            <div class="col-md-4 mb-4">
                                                <div class="card h-100 border-bottom-primary">
                                                    <div class="card-body">
                                                        <div class="d-flex justify-content-between align-items-start mb-2">
                                                            <h5 class="card-title font-weight-bold text-dark">${item.title}</h5>
                                                            <span class="badge ${item.aiLabel == 'HOT' ? 'badge-ai-hot' : (item.aiLabel == 'WARM' ? 'badge-ai-warm' : 'badge-ai-cold')}">
                                                                <i class="fas fa-fire-alt"></i> ${item.aiLabel}
                                                            </span>
                                                        </div>
                                                        <p class="card-text small text-muted"><i class="fas fa-map-marker-alt"></i> ${item.address}</p>
                                                        <div class="row no-gutters align-items-center">
                                                            <div class="col mr-2">
                                                                <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">Độ khớp nhu cầu</div>
                                                                <div class="row no-gutters align-items-center">
                                                                    <div class="col-auto">
                                                                        <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"><fmt:formatNumber value="${item.aiScore * 100}" maxFractionDigits="0"/>%</div>
                                                                    </div>
                                                                    <div class="col">
                                                                        <div class="progress progress-sm mr-2">
                                                                            <div class="progress-bar bg-primary" role="progressbar"
                                                                                 style="width: <fmt:formatNumber value="${item.aiScore * 100}" maxFractionDigits="0"/>%"
                                                                                 aria-valuenow="${item.aiScore * 100}" aria-valuemin="0" aria-valuemax="100"></div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <hr>
                                                        <div class="d-flex justify-content-between small">
                                                            <span><i class="fas fa-tag"></i> ${item.price} tỷ</span>
                                                            <span><i class="fas fa-expand"></i> ${item.area} m²</span>
                                                        </div>
                                                    </div>
                                                    <div class="card-footer bg-white border-0">
                                                        <a href="#" class="btn btn-outline-primary btn-sm btn-block">Xem chi tiết</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>

                                        <c:if test="${empty recommendedProducts}">
                                            <div class="col-12 text-center py-4">
                                                <p class="text-muted">Cập nhật nhu cầu khách hàng để AI đưa ra gợi ý phù hợp nhất.</p>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@ include file="/common/admin/footer.jsp" %>
        </div>
    </div>
    <script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
    <script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
    <script src="<c:url value='/template/admin/js/sb-admin-2.min.js' />"></script>
</body>
</html>