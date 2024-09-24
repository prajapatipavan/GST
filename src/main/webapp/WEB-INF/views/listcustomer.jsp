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
  

        <h1 class="mb-4">Customer List</h1> 
        
        
        
        <!-- Transactions Table -->
      <table class="table table-striped">
    <thead>
        <tr>
            <th>customerName</th>
            <th>contactNumber</th>
            <th>email</th>
            <th>gstNumber</th>
            <th>address</th>
            <th>treasaction</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listcustomers}" var="catagories">
          
                <tr>
                    <td>${catagories.customerName}</td>
                    <td>${catagories.contactNumber}</td>
                    <td>${catagories.email}</td>
                    <td>${catagories.gstNumber}</td>
                    <td>${catagories.address}</td>
                    
                
                    <td><a href="customertrasaction?email=${catagories.email}">View</a></td>
                </tr>
            
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
