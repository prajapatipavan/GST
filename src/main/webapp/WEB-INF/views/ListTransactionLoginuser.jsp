<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transaction</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        table {
            margin: 25px 0;
            font-size: 16px;
            text-align: left;
        }
        th, td {
            padding: 12px;
            vertical-align: middle;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
    <!-- Include Navbar -->
    <jsp:include page="Navbar.jsp"></jsp:include>

    <div class="container mt-4">
        <!-- Button to add new transaction -->
        <div class="text-right mb-3">
            <a href="addgstTransaction" class="btn btn-primary btn-rounded"><i class="fa fa-plus"></i> Add Transaction</a>
        </div>

        <h1 class="mb-4">Transaction List</h1> 
        
        
        
        <!-- Transactions Table -->
        <table class="table table-striped">
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
                <c:forEach items="${gstTransactionList}" var="transaction">
                
                  <c:if test="${transaction.active == true}">
                    <tr>
                        <td>${transaction.user.username}</td>
                        <td>${transaction.gstrate.rate}</td>
                        <td>${transaction.gstcatagory.catagoryName}</td>
                        <td>${transaction.amount}</td>
                        <td>${transaction.date}</td>
                        <td>${transaction.gstNumber}</td>
                        <td>${transaction.gstAmount}</td>
                        <td>${transaction.totalAmount}</td>
                         <td><a href="Edittransaction?transactionId=${transaction.transactionId}">Edit</a></td>
                    </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
