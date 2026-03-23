<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<c:url var="editProductURL" value="/admin/product/edit" />
<c:url var="editProductURL" value="/admin/product/edit">
    <c:param name="id" value="${model.id}"></c:param>
</c:url>

<html>
<head>
    <title>Chi tiết sản phẩm</title>
    <link href="<c:url value='/template/admin/css/sb-admin-2.min.css' />" rel="stylesheet">
    <link href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet">
</head>
<body id="page-top">
    <div id="wrapper">
        <%@ include file="/common/admin/sidebar.jsp" %>
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <%@ include file="/common/admin/header.jsp" %>

                <div class="container-fluid">
                    <h1 class="h3 mb-4 text-gray-800">Chi tiết sản phẩm: ${model.title}</h1>

                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-4 text-center">
                                    <c:if test="${not empty model.base64Image}">
                                        <img src="${model.base64Image}" class="img-fluid rounded shadow" style="max-height: 400px;">
                                    </c:if>
                                    <c:if test="${empty model.base64Image}">
                                        <img src="<c:url value='/template/admin/images/no-image.png'/>" class="img-fluid">
                                    </c:if>
                                </div>

                                <div class="col-md-8">
                                    <table class="table table-striped">
                                        <tr>
                                            <th width="30%">Tiêu đề:</th>
                                            <td>${model.title}</td>
                                        </tr>
                                        <tr>
                                            <th>Giá:</th>
                                            <td class="text-danger font-weight-bold">${model.price} VNĐ</td>
                                        </tr>
                                        <tr>
                                            <th>Diện tích:</th>
                                            <td>${model.area} m²</td>
                                        </tr>
                                        <tr>
                                            <th>Địa chỉ:</th>
                                            <td>${model.address}</td>
                                        </tr>
                                        <tr>
                                            <th>Phường/Quận:</th>
                                            <td>${model.wardId}</td> </tr>
                                        <tr>
                                            <th>Hướng:</th>
                                            <td>${model.direction}</td>
                                        </tr>
                                        <tr>
                                            <th>Số phòng ngủ:</th>
                                            <td>${model.bedrooms}</td>
                                        </tr>
                                        <tr>
                                            <th>Trạng thái:</th>
                                            <td><span class="badge badge-success">${model.status}</span></td>
                                        </tr>
                                    </table>
                                    <div class="mt-4">
                                        <a href="<c:url value='/admin/product'/>" class="btn btn-secondary"> Quay lại danh sách</a>
                                        <a href="${editProductURL}" class="btn btn-primary">Chỉnh sửa</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>