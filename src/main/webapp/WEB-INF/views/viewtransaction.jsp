<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<style>
table {
	width: 50%;
	border-collapse: collapse;
	margin: 25px 0;
	font-size: 18px;
	text-align: left;
}

th, td {
	padding: 12px;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #f5f5f5;
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Star Admin2</title>
<!-- plugins:css -->
<link rel="stylesheet" href="asset/vendors/feather/feather.css">
<link rel="stylesheet"
	href="asset/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="asset/vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet"
	href="asset/vendors/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="asset/vendors/typicons/typicons.css">
<link rel="stylesheet"
	href="asset/vendors/simple-line-icons/css/simple-line-icons.css">
<link rel="stylesheet" href="asset/vendors/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="asset/vendors/bootstrap-datepicker/bootstrap-datepicker.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<!-- endinject -->
<!-- Plugin css for this page -->
<link rel="stylesheet"
	href="asset/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
<link rel="stylesheet" type="text/css"
	href="asset/js/select.dataTables.min.css">
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="asset/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="asset/images/favicon.png" />
<style type="text/css">
.totalamount {
	position: relative;
	left: 75%;
}

  #transactionTable {
    width: 100%; /* Make the table take up the full width of its container */
    max-width: 1200px; /* Adjust as needed for your layout */
    margin: 0 auto; /* Center the table horizontally */
    border-collapse: collapse; /* Collapse table borders to remove spacing between cells */
}

#transactionTable th, #transactionTable td {
    padding: 8px; /* Add padding for readability */
    text-align: left; /* Align text to the left */
    border: 1px solid #ddd; /* Add a light border for separation */
}

</style>

</head>
<body class="with-welcome-text">
	<div class="container-scroller">


		<!-- partial:partials/_navbar.html -->
		<%@include file="NavbarDashbord.jsp"%>

		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->
			<%@include file="sidebar.jsp"%>

			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-sm-12">
							<div class="home-tab">
								<div
									class="d-sm-flex a$lign-items-center justify-content-between border-bottom">
									<ul class="nav nav-tabs" role="tablist">
										<li class="nav-item"><a class="nav-link active ps-0"
											id="home-tab" data-bs-toggle="tab" href="#overview"
											role="tab" aria-controls="overview" aria-selected="true">Overview</a>
										</li>

									</ul>

								</div>
								<div class="tab-content tab-content-basic">
									<div class="tab-pane fade show active" id="overview"
										role="tabpanel" aria-labelledby="overview">


										<div class="row">



											<h4>All Transaction: ${puser.username}(UserId:${selectedUserId})</h4>

 
                                        <form action="viewtransaction" method="get">
                                             <select name="userId"  required onchange="this.form.submit()" >
                                            
                                                <c:forEach items="${pusers}" var="u">
                                             
                                                <option value="${u.userId}">${u.username}</option>
                                             </c:forEach>
                                             </select>
</form>
										</div>


               

										<table id="transactionTable" class="display">
											<thead>
												<tr>

													<th>User</th>
													<th>GST Rate</th>
													<th>GST Category</th>
													<th>Amount</th>
													<th>Date</th>
													<th>GST Number</th>
													<th>GST Amount</th>
													<th>Total Amount</th>
													<th>Action</th>

												</tr>
											</thead>
											<tbody>
												<c:forEach items="${gstfiltertransaction}" var="transaction">
												
													<tr>
													
														<td>${transaction.user.username}</td>
														<td>${transaction.gstrate.rate}</td>
														<td>${transaction.gstcatagory.catagoryName}</td>
														<td>${transaction.amount}</td>
														<td>${transaction.date}</td>
														<td>${transaction.gstNumber}</td>
														<td>${transaction.gstAmount}</td>
														<td>${transaction.totalAmount}</td>

														<td>
															<a href="/deletetransactions?transactionId=${transaction.transactionId}&userId=${selectedUserId}" class="btn btn-danger">Delete</a>
														</td>
													</tr>
											
												</c:forEach>
											</tbody>
										</table>

										<hr>
										<div class="totalamount">
											<h4>Total All Amount</h4>
											:${totalAmount}
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- content-wrapper ends -->
			<!-- partial:partials/_footer.html -->
			<footer class="footer">
				<div
					class="d-sm-flex justify-content-center justify-content-sm-between">
					
				</div>
			</footer>
			<!-- partial -->
		</div>
		<!-- main-panel ends -->
	</div>
	<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="vendors/js/vendor.bundle.base.js"></script>
	<script
		src="asset/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page -->
	<script src="asset/vendors/chart.js/chart.umd.js"></script>
	<script src="asset/vendors/progressbar.js/progressbar.min.js"></script>
	<!-- End plugin js for this page -->
	<!-- inject:js -->
	<script src="asset/js/off-canvas.js"></script>
	<script src="asset/js/template.js"></script>
	<script src="asset/js/settings.js"></script>
	<script src="asset/js/hoverable-collapse.js"></script>
	<script src="asset/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="asset/js/jquery.cookie.js" type="text/javascript"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
	<script src="asset/js/dashboard.js"></script>
	<!-- <script src="asset/js/Chart.roundedBarCharts.js"></script> -->
	<!-- End custom js for this page-->
</body>
</html>