<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transaction List</title>
    
    <!-- DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <!-- DataTables JS -->
    <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>

    <script>
        // Initialize DataTables when the document is ready
        $(document).ready(function() {
            $('#transactionTable').DataTable();
        });
    </script>
</head>

<body>

  <%@include file="about.jsp" %><br><br>

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
        <th>Status</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="transaction" items="${distransaction}">
        <c:if test="${transaction.active == false}">
          <tr>
            <td>${transaction.user.username}</td>
            <td>${transaction.gstrate.rate}</td>
            <td>${transaction.gstcatagory.catagoryName}</td>
            <td>${transaction.amount}</td>
            <td>${transaction.date}</td>
            <td>${transaction.gstNumber}</td>
            <td>${transaction.gstAmount}</td>
            <td>${transaction.totalAmount}</td>
            <td>${transaction.active ? 'Active' : 'Inactive'}</td>
            <td>
              <a href="activatetransation?transactionId=${transaction.transactionId}">Activate</a>
            </td>
          </tr>
        </c:if>
      </c:forEach>
    </tbody>
  </table>

</body>

</html>