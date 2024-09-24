<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

   <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
    <!-- jQuery (required for DataTables) -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- DataTables JS -->
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Transaction List</title>

  
    <style>
        table {
            width: 100%;
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
  <%@include file="bootstraplink.jsp"%>


    <div class="container-scroller">
      
        <%@include file="NavbarDashbord.jsp"%>

        <!-- partial -->
        <div class="container-fluid page-body-wrapper">
         
            <%@include file="sidebar.jsp"%>

            <!-- partial -->
            <div class="main-panel">
                <div class="content-wrapper">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="home-tab">
                                <div class="d-sm-flex align-items-center justify-content-between border-bottom">
                                    <ul class="nav nav-tabs" role="tablist">
                                        <li class="nav-item">
                                            <a class="nav-link active ps-0" id="home-tab" data-bs-toggle="tab" href="#overview" role="tab" aria-controls="overview" aria-selected="true">Overview</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="tab-content tab-content-basic">
                                    <div class="tab-pane fade show active" id="overview" role="tabpanel" aria-labelledby="overview">
                                        <div class="row">
                                            <h1>Transaction</h1>
 
                                         <form action="viewtransaction" method="get">
    <label for="user">User:</label> 
    <select id="user" name="userId" required onchange="this.form.submit()">
        <option value="">-- Select a User --</option> <!-- Placeholder -->
        <c:forEach items="${puser}" var="user">
            <option value="${user.userId}">${user.username}</option>
        </c:forEach>
    </select>
</form>

                                        <table id="transactionTable" class="display">
        <thead>
            <tr>
                <th>User</th>
                <th>GST Rate</th>
                <th>GST Category</th>
                <th>Amount</th>
                <th>Date</th>
                <th>GST Number</th>
                
                <th>Total Amount</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${gsttansaction}" var="transaction">
                <tr>
                    <td>${transaction.user.username}</td>
                    <td>${transaction.gstrate.rate}</td>
                    <td>${transaction.gstcatagory.catagoryName}</td>
                    <td>${transaction.amount}</td>
                    <td>${transaction.date}</td>
                    
                    <td>${transaction.gstAmount}</td>
                    <td>${transaction.totalAmount}</td>
                    <td><a href="/deletetransaction?transactionId=${transaction.transactionId}" class="btn btn-danger">DELETE</a></td>
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
                    <div class="d-sm-flex justify-content-center justify-content-sm-between">
                        <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Premium
                            <a href="https://www.bootstrapdash.com/" target="_blank">Bootstrap admin template</a> from BootstrapDash.
                        </span> 
                        <span class="float-none float-sm-end d-block mt-1 mt-sm-0 text-center">Copyright © 2023. All rights reserved.</span>
                    </div>
                </footer>
                <!-- partial -->
            </div>
            <!-- main-panel ends -->
        </div>
        <!-- page-body-wrapper ends -->
    </div>
     <script>
    $(document).ready(function() {
        $('#transactionTable').DataTable({
            "paging": true,
            "searching": true,
            "ordering": true,
            "info": true,
            "lengthChange": true,
            "autoWidth": false
        });
    });
    </script>
</body>
</html>
