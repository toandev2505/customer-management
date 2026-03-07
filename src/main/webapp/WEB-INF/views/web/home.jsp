<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Customer Management</title>

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
<body>
    <c:if test="${not empty message}">
        <div class="alert alert-${alert}" role="alert">
            ${message}
        </div>
    </c:if>
    <h1>Oops! We&apos;re still working on this page. Feel free to check out our other links instead.</h1>

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