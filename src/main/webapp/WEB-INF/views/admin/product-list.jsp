<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Product Management</title>

    <!-- Custom fonts for this template -->
    <link href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value='/template/admin/css/sb-admin-2.min.css' />" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.min.css' />" rel="stylesheet">

    <!-- sweet alert -->
    <link rel="stylesheet" href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />

    <style>
    table.table thead th,
    table.table tfoot th,
    table.table tbody td {
        vertical-align: middle !important;
        text-align: center !important;
    }

    table.table .form-check-input {
        position: static; /* Ghi đè lại absolute của Bootstrap */
        margin-top: 0;
        margin-left: 0;
        cursor: pointer;
        width: 16px;
        height: 16px;
    }
    </style>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <%@ include file="/common/admin/sidebar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <%@ include file="/common/admin/header.jsp" %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <c:if test="${not empty message}">
                    	<div class="alert alert-${alert}" role="alert">
                    		${message}
                    	</div>
                    </c:if>

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Product Management</h1>
                    <p class="mb-4">Manage and monitor your property listings efficiently. Track inventory status,
                        update key specifications, and organize your real estate portfolio to maximize sales opportunities.</p>

                    <!-- DataTales -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 d-sm-flex align-items-center justify-content-between">
                            <h6 class="m-0 font-weight-bold text-primary">Products List</h6>
                            <div>
                                <a href='<c:url value="/admin/product/edit"/>'
                                   class="btn btn-sm btn-success shadow-sm" title="Insert product">
                                    <i class="fas fa-plus fa-sm text-white-50"></i> Insert
                                </a>

                                <button type="button" id="btnDelete" onclick="warningBeforeDelete()"
                                        class="btn btn-sm btn-danger shadow-sm" title="Delete products list">
                                    <i class="fas fa-trash-alt fa-sm text-white-50"></i> Delete
                                </button>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th class="text-center" style="vertical-align: middle;">
                                                <input class="form-check-input" type="checkbox" value="" id="checkAll">
                                              </th>
                                            <th>Title</th>
                                            <th>Type</th>
                                            <th>Address</th>
                                            <th>Location</th>
                                            <th>Price</th>
                                            <th>Area</th>
                                            <th>Number of Bedrooms</th>
                                            <th>Direction</th>
                                            <th>Status</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th class="text-center" style="vertical-align: middle;">
                                                <input class="form-check-input" type="checkbox" value="" id="checkAll">
                                            </th>
                                            <th>Title</th>
                                            <th>Type</th>
                                            <th>Address </th>
                                            <th>Location</th>
                                            <th>Price</th>
                                            <th>Area</th>
                                            <th>Number of Bedrooms</th>
                                            <th>Direction</th>
                                            <th>Status</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="item" items="${model.listResult}">
                                            <tr>
                                                <td class="text-center" style="vertical-align: middle;">
                                                    <input class="form-check-input" type="checkbox" value="${item.id}"
                                                    id="checkbox_${item.id}">
                                                </td>
                                                <td>${item.title}</td>
                                                <td>${item.type}</td>
                                                <td>${item.address}</td>
                                                <td>
                                                    <i class="fas fa-map-marker-alt text-danger"></i>
                                                    ${item.wardName}, ${item.provinceName}
                                                </td>
                                                <td>${item.price}</td>
                                                <td>${item.area}</td>
                                                <td>${item.bedrooms}</td>
                                                <td>${item.direction}</td>
                                                <td>${item.status}</td>
                                                <td>
                                                    <c:url var="updateProductURL" value="/admin/product/edit">
                                                	    <c:param name="id" value="${item.id}"></c:param>
                                                	</c:url>
                                                	<c:url var="detailProductURL" value="/admin/product/detail">
                                                        <c:param name="id" value="${item.id}"></c:param>
                                                    </c:url>

                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                    title="Edit" href="${updateProductURL}">
                                                    <i class="fas fa-edit"></i></a>
                                                    <a class="btn btn-sm btn-info" data-toggle="tooltip"
                                                    title="Xem chi tiết" href="${detailProductURL}">
                                                         <i class="fas fa-eye"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <%@ include file="/common/admin/footer.jsp" %>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
    <script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

    <!-- Core plugin JavaScript-->
    <script src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js' />"></script>

    <!-- Custom scripts for all pages-->
    <script src="<c:url value='/template/admin/js/sb-admin-2.min.js' />"></script>

    <!-- Page level plugins -->
    <script src="<c:url value='/template/admin/vendor/datatables/jquery.dataTables.min.js' />"></script>
    <script src="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.min.js' />"></script>

    <!-- Page level custom scripts -->
    <script src="<c:url value='/template/admin/js/demo/datatables-demo.js' />"></script>
    <script src="/template/admin/sweetalert/sweetalert2.min.js"></script>
</body>
</html>