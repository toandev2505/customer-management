<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<c:url var="customerAPI" value="/api/customer" />
<c:url var="customerURL" value="/admin/customer-management"/>
<c:url var="editCustomerURL" value="/admin/customer-management/edit"/>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Customer Management</title>

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

                    <c:if test="${not empty model.id}">
                        <h1 class="h3 mb-2 text-gray-800">New Customer Editing</h1>
                    </c:if>
                    <c:if test="${empty model.id}">
                        <h1 class="h3 mb-2 text-gray-800">New Customer Insertion</h1>
                    </c:if>

                    <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
                        <div class="mb-3">
                          <label for="name" class="form-label">Customer Name</label>
                          <form:input class="form-control" id="name" placeholder="Toan Handsome" path="name"/>
                        </div>
                        <div class="mb-3">
                          <label for="phone" class="form-label">Phone Of Customer</label>
                          <form:input class="form-control" id="phone" placeholder="0123456789" path="phone"/>
                        </div>

                        <form:hidden path="id" id="customerId"/>

                        <div class="d-grid gap-2 d-md-block justify-content-center">
                          <c:if test="${empty model.id}">
                            <button type="button" class="btn btn-primary me-md-2"
                                id="btnAddOrUpdateCustomer">Insert Customer</button>
                          </c:if>
                          <c:if test="${not empty model.id}">
                            <button type="button" class="btn btn-primary me-md-2"
                                id="btnAddOrUpdateCustomer">Update Customer</button>
                          </c:if>
                          <a class="btn btn-light" href="<c:url value='/admin/customer-management' />"
                            role="button">Cancel</a>
                        </div>
                    </form:form>
                </div>

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
    <script src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js' />"></script>
    <script>
        $('#btnAddOrUpdateCustomer').click(function(e){
        			e.preventDefault();
        			var data = {};
        			var formData = $('#formSubmit').serializeArray();
        			$.each(formData, function(i, v){
        				data[""+v.name+""] = v.value;
        			});

        			if (data.name.trim() === "") {
                            swal("Lỗi!", "Tên khách hàng không được để trống", "error");
                            return;
                        }

                        if (data.phone.trim() === "") {
                            swal("Lỗi!", "Số điện thoại không được để trống", "error");
                            return;
                        }

        			var id = $('#customerId').val();
        			if (id == ""){
        				addCustomer(data);
        			} else {
        				updateCustomer(data);
        			}
        		});

        		function addCustomer(data){
        			$.ajax({
        				url: '${customerAPI}',
        				type: 'POST',
        				contentType: 'application/json',
        				data: JSON.stringify(data),
        				dataType: 'json',
        				success: function(result){
        					window.location.href = "${editCustomerURL}?id="+ result.id +"&message=insert_success";
        				},
        				error: function(result){
        					window.location.href = "${customerURL}?message=error_system";
        				}
        			});
        		}

        		function updateCustomer(data){
        			$.ajax({
        				url: '${customerAPI}',
        				type: 'PUT',
        				contentType: 'application/json',
        				data: JSON.stringify(data),
        				dataType: 'json',
        				success: function(result){
        					window.location.href ="${editCustomerURL}?id="+ result.id +"&message=update_success";
        				},
        				error: function(result){
        					window.location.href = "${editCustomerURL}?id="+ result.id +"&message=error_system";
        				}
        			});
        		}
    </script>
</body>
</html>