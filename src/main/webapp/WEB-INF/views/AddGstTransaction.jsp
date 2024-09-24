<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            width: 80%;
            max-width: 800px;
            margin: 30px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }
        header {
            text-align: center;
            margin-bottom: 20px;
        }
        h1 {
            color: #333;
        }
        form {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
        }
        form > div {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 8px;
            font-weight: bold;
            color: #333;
        }
        input, select {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        input:focus, select:focus {
            border-color: #007BFF;
            outline: none;
        }
        input[type="submit"] {
            grid-column: span 2;
            background-color: #28a745;
            color: #fff;
            border: none;
            padding: 15px;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
            text-align: center;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
        .form-group {
            grid-column: span 2;
        }
        .form-group small {
            color: #666;
        }
        .error {
            color: red;
            font-size: 14px;
            margin-top: -10px;
            margin-bottom: 15px;
        }
    </style>
  <script>
    // Function to calculate and sum selected product prices, GST amounts, and total GST rates
    function calculateTotalAmount() {
        var products = document.getElementById('products'); // Product select box
        var totalAmount = 0;
        var gstAmount = 0;
        var totalRate = 0; // To accumulate total GST rate

        // Loop through selected products
        for (var i = 0; i < products.options.length; i++) {
            if (products.options[i].selected) {
                var price = parseFloat(products.options[i].getAttribute('data-price')); // Get product price
                var rate = parseFloat(products.options[i].getAttribute('data-rate')); // Get product GST rate

                totalAmount += price; // Sum prices
                gstAmount += price * (rate / 100); // Calculate GST for each product and sum
                totalRate += rate; // Sum GST rates for all selected products
            }
        }

        // Update the amount, GST amount, total GST rate, and total amount fields
        document.getElementById('amount').value = totalAmount.toFixed(2);
        document.getElementById('gstAmount').value = gstAmount.toFixed(2);
        document.getElementById('totalRate').value = totalRate.toFixed(2); // Display total GST rate
        document.getElementById('totalAmount').value = (totalAmount + gstAmount).toFixed(2);
    }

    // Event listeners for product selection
    document.addEventListener('DOMContentLoaded', function () {
        document.getElementById('products').addEventListener('change', calculateTotalAmount);
    });
</script>
  
    
</head>
<body>
    <div class="container">
        <header>
            <h1>Create New GST Transaction</h1>
        </header>
        <form action="createTransaction" method="post">
            <div>
                <label for="user">User:</label>
                <select id="user" name="user" required>
                    <c:forEach items="${puser}" var="user">
                        <option value="${user.userId}">${user.username}</option>
                    </c:forEach>
                </select>
            </div>

            <div>
                <label for="customerName">Customer Name:</label>
                <input type="text" id="customerName" name="customerName" required />
            </div>

            <div>
                <label for="contactNumber">Contact Number:</label>
                <input type="text" id="contactNumber" name="contactNumber" required />
            </div>

            <div>
                <label for="email">Email:</label>
                <input type="text" id="email" name="email" required />
            </div>

            <div>
                <label for="gstNumber">Customer GST Number:</label>
                <input type="text" id="gstNumber" name="gstNumber" />
            </div>

            <div>
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required />
            </div>

            <div class="form-group">
                <label for="products">Select Products:</label>
                <select class="form-control" id="products" name="products" multiple required>
                <c:forEach items="${listproduct}" var="product">
                    <option value="${product.productId}" data-price="${product.productprize}" data-rate="${product.rate}">
                        ${product.productName} - ₹${product.productprize} - ${product.rate}
                        
                    </option>
                </c:forEach>
            </select>
              
            </div>

            <div>
                <label for="rate">GST Rate (%):</label>
             
                <input type="text" id="totalRate" name="rate" required />
            </div>

            <div>
                <label for="category">GST Category:</label>
                <select id="category" name="gstcatagory" required>
                    <c:forEach items="${gstCategories}" var="category">
                        <option value="${category.catagoryId}">${category.catagoryName}</option>
                    </c:forEach>
                </select>
            </div>

            <div>
                <label for="amount">Amount (₹):</label>
                <input type="text" id="amount" name="amount" required />
            </div>

            <div>
                <label for="date">Date:</label>
                <input type="date" id="date" name="date" required />
            </div>

            <div>
                <label for="gstAmount">GST Amount (₹):</label>
                <input type="text" id="gstAmount" name="gstAmount"  readonly />
            </div>

            <div>
                <label for="totalAmount">Total Amount (₹):</label>
                <input type="text" id="totalAmount" name="totalAmount" readonly />
            </div>

            <input type="submit" value="Create Transaction" />
        </form>
    </div>
</body>
</html>
