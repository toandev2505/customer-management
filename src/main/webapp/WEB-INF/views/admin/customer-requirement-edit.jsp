<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm nhu cầu khách hàng</title>
    <link href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet">
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
                    <h1 class="h3 mb-4 text-gray-800">Thêm nhu cầu cho: ${customer.name}</h1>

                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Tiêu chí tìm kiếm bất động sản</h6>
                        </div>
                        <div class="card-body">
                            <form id="formRequirement">
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <label>Giá tối thiểu (VNĐ):</label>
                                        <input type="number" name="minPrice" class="form-control" placeholder="Ví dụ: 1000000000">
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label>Giá tối đa (VNĐ):</label>
                                        <input type="number" name="maxPrice" class="form-control" placeholder="Ví dụ: 5000000000">
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <label>Diện tích mong muốn (m²):</label>
                                        <input type="number" name="preferredArea" class="form-control" step="0.1">
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label>Loại bất động sản:</label>
                                        <select name="propertyType" class="form-control">
                                            <c:forEach var="type" items="${propertyTypes}">
                                                <option value="${type}">${type.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>Khu vực ưu tiên (Phường/Xã):</label>
                                    <div class="border p-3 rounded" style="max-height: 200px; overflow-y: auto;">
                                        <div class="row">
                                            <c:forEach var="ward" items="${wards}">
                                                <div class="col-md-4">
                                                    <div class="custom-control custom-checkbox">
                                                        <input type="checkbox" class="custom-control-input"
                                                               id="ward_${ward.id}" name="preferredWardIds" value="${ward.id}">
                                                        <label class="custom-control-label" for="ward_${ward.id}">${ward.name}</label>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>Ghi chú chi tiết:</label>
                                    <textarea name="note" class="form-control" rows="4" placeholder="Ví dụ: Khách thích nhà hẻm xe hơi, gần trường học..."></textarea>
                                </div>

                                <input type="hidden" name="customerId" value="${customer.id}">

                                <hr>
                                <button type="button" id="btnSaveRequirement" class="btn btn-success shadow-sm">
                                    <i class="fas fa-save"></i> Lưu nhu cầu
                                </button>
                                <a href="<c:url value='/admin/customer-management'/>" class="btn btn-secondary shadow-sm">Hủy</a>
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
    <script src="<c:url value='/template/admin/js/sb-admin-2.min.js' />"></script>
    <script src="/template/admin/sweetalert/sweetalert2.min.js"></script>

    <script>
        $('#btnSaveRequirement').click(function(e) {
            e.preventDefault();
            var data = {};
            var formData = $('#formRequirement').serializeArray();
            var preferredWardIds = [];

            $.each(formData, function(i, v) {
                if (v.name === 'preferredWardIds') {
                    preferredWardIds.push(v.value);
                } else {
                    data["" + v.name + ""] = v.value;
                }
            });
            data['preferredWardIds'] = preferredWardIds;

            saveRequirement(data);
        });

        function saveRequirement(data) {
            $.ajax({
                url: '/api/admin/customer/requirement',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    swal("Thành công", "Nhu cầu đã được lưu lại", "success").then(() => {
                        window.location.href = "/admin/customer-management?message=insert_success";
                    });
                },
                error: function (error) {
                    swal("Lỗi", "Hệ thống gặp trục trặc khi lưu", "error");
                }
            });
        }
    </script>
</body>
</html>