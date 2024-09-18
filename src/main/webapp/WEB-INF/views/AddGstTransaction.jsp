<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create GST Transaction</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 90%;
            max-width: 900px;
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }
        header {
            text-align: center;
            margin-bottom: 20px;
        }
        h1 {
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 8px;
            font-weight: bold;
            color: #333;
        }
        select, input[type="text"], input[type="date"] {
            margin-bottom: 15px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        input[type="text"]:focus, input[type="date"]:focus, select:focus {
            border-color: #007BFF;
            outline: none;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: #fff;
            border: none;
            padding: 15px;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
        .error {
            color: red;
            font-size: 14px;
            margin-top: -10px;
            margin-bottom: 15px;
        }
    </style>
   <script>
    function calculateTotalAmount() {
        var amount = parseFloat(document.getElementById('amount').value);
        var rateSelect = document.getElementById('rate');
        var selectedOption = rateSelect.options[rateSelect.selectedIndex];
        var gstRate = parseFloat(selectedOption.getAttribute('data-rate'));

        var gstAmount = amount * (gstRate / 100);
        var totalAmount = amount + gstAmount;

        document.getElementById('totalAmount').value = totalAmount.toFixed(2);
        document.getElementById('gstAmount').value = gstAmount.toFixed(2);
    }

    document.addEventListener('DOMContentLoaded', function() {
        document.getElementById('amount').addEventListener('input', calculateTotalAmount);
        document.getElementById('rate').addEventListener('change', calculateTotalAmount);
    });
</script>
   
</head>
<body>
    <div class="container">
        <header>
            <h1>Create New GST Transaction</h1>
        </header>
        <form action="createTransaction" method="post">
            <label for="user">User:</label>
            <select id="user" name="user" required>
    <c:forEach items="${puser}" var="user">
        <option value="${user.userId}">${user.username}</option>
    </c:forEach>
</select>
            
            
    
            <label for="rate">GST Rate (%):</label>
            <select id="rate" name="gstrate" required>
                <c:forEach items="${gstrates}" var="rate">
                    <option value="${rate.rateId}"  data-rate="${rate.rate}">${rate.rate}</option>
                </c:forEach>
            </select>

            <label for="category">GST Category:</label>
            <select id="category" name="gstcatagory" required>
                <c:forEach items="${gstCategories}" var="category">
                    <option value="${category.catagoryId}">${category.catagoryName}</option>
                </c:forEach>
            </select>

            <label for="amount">Amount (₹):</label>
            <input type="text" id="amount" name="amount" required />

            <label for="gstNumber">GST Number:</label>
            <input type="text" id="gstNumber" name="gstNumber" required />

            <label for="date">Date:</label>
            <input type="date" id="date" name="date" required />
            
             <label for="gstAmount">GST AMOUNT (₹):</label>
            <input type="text" id="gstAmount" name="gstAmount" readonly />
            

            <label for="totalAmount">Total Amount (₹):</label>
            <input type="text" id="totalAmount" name="totalAmount" readonly />
            
            

            <input type="submit" value="Create Transaction" />
        </form>
    </div>
</body>
</html>
