<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Invoice</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            line-height: 1.6;
        }
        h2, h3 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .form-group {
            margin-bottom: 15px;
            border: 1px solid #ddd;
            padding: 10px;
            border-radius: 5px;
        }
        label {
            font-weight: bold;
        }
        .total-amount {
            font-size: 1.2em;
            font-weight: bold;
        }
        .invoice-section {
            margin-bottom: 20px;
        }
        .invoice-details {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

 <h2>Shop Details</h2>
    
    
    <div class="form-group invoice-section">
        <div class="invoice-details">
            <label>Company Name:</label>
            <span>${customer.user.username}</span>
        </div>
        <div class="invoice-details">
            <label>company Email:</label>
            <span>${customer.user.email}</span>
        </div>
       
    </div>

    <h2>Create Invoice</h2>
    
    
    <div class="form-group invoice-section">
        <div class="invoice-details">
            <label>Invoice Number:</label>
            <span>${invoiceNumber}</span>
        </div>
        <div class="invoice-details">
            <label>Invoice Date:</label>
            <span>${invoicedate}</span>
        </div>
        <div class="invoice-details">
            <label>Customer Name:</label>
            <span>${customer.customerName}</span>
        </div>
        <div class="invoice-details">
            <label>Customer Address:</label>
            <span>${customer.address}</span>
        </div>
    </div>

    <!-- Product Details Table -->
    <h3>Product Details</h3>
    <h4>Total Transactions: ${customertransaction.size()}</h4>
    <table>
        <thead>
            <tr>
                <th>Sr. No</th>
                <th>Item</th>
                <th>Price (₹)</th>
                <th>GST (%)</th>
                <th>GST Amount (₹)</th>
                <th>Total Amount (₹)</th>
            </tr>
        </thead>
        <tbody>
            <% int srno = 1; %>
            <c:forEach var="transaction" items="${customertransaction}">
                <c:forEach var="product" items="${transaction.transaction.products}">
                    <c:if test="${transaction.transaction.active == true}">
                        <tr>
                            <td><%= srno++ %></td>
                            <td>${product.productName}</td>
                            <td>₹${product.productprize}</td>
                            <td>${product.rate}</td>
                            <!-- Calculate GST Amount -->
                            <c:set var="gstAmount" value="${product.productprize * (product.rate / 100)}"></c:set>
                            <td>₹${gstAmount}</td>
                            <!-- Calculate Total Amount -->
                            <c:set var="totalAmount" value="${product.productprize + gstAmount}" />
                            <td>₹${totalAmount}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </tbody>
    </table>
    
    <div class="form-group">
        <h4>Total GST Amount:</h4>
        <c:set var="totalgstAmount" value="0"></c:set>
        <c:set var="grandTotal" value="0"></c:set>
          <c:set var="SubTotal" value="0"></c:set>
        
        <c:forEach var="transaction" items="${customertransaction}">
            <c:forEach var="product" items="${transaction.transaction.products}">
           <c:if test="${transaction.transaction.active == true}">
                <c:set var="productgstAmount" value="${product.productprize * (product.rate / 100)}"></c:set>
                <c:set var="totalgstAmount" value="${productgstAmount + totalgstAmount}"></c:set>
                <c:set var="productAmount" value="${product.productprize + productgstAmount}"></c:set>
                    <c:set var="SubTotal" value="${product.productprize +SubTotal}"></c:set>
                <c:set var="grandTotal" value="${grandTotal + productAmount}"></c:set>
                </c:if>
            </c:forEach>
        </c:forEach>
         <p>Sub  Total: <strong>₹${SubTotal}</strong></p>
        <p>Total GST Amount: <strong>₹${totalgstAmount}</strong></p>
        <hr>
            <p>Grand Total: <strong>₹${grandTotal}</strong></p>
    </div>
    
    </div>

</body>
</html>
