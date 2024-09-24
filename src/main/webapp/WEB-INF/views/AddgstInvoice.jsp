<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Invoice</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f9f9f9;
        }
        h2, h3 {
            color: #333;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }
        .user-details, .invoice-form, .transaction-table {
            margin-bottom: 30px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 10px;
        }
        table th, table td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        table th {
            background-color: #f4f4f4;
        }
        .total-amount {
            text-align: right;
            font-size: 18px;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input, select, button {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        button {
            background-color: #28a745;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- User Details Section -->
        <div class="user-details">
            <h2>User Details</h2>
            <p><strong>User ID:</strong> ${userd.userId}</p>
            <p><strong>Username:</strong> ${userd.username}</p>
            <p><strong>Email:</strong> ${userd.email}</p>
        </div>

        <!-- Transaction Table Section -->
        <div class="transaction-table">
            <h3>Select Transactions for Invoice</h3>
            <table>
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
                      
                    </tr>
                </thead>
                <tbody>
                     <c:forEach var="transaction" items="${gstTransactionList}">
                <tr>
                     <c:if test="${transaction.active == true}">
                    <td>${transaction.user.username}</td>
                    <td>${transaction.gstrate.rate}</td>
                    <td>${transaction.gstcatagory.catagoryName}</td>
                    <td>${transaction.amount}</td>
                    <td>${transaction.date}</td>
                    <td>${transaction.gstNumber}</td>
                    <td>${transaction.gstAmount}</td>
                    <td>${transaction.totalAmount}</td>
                  </c:if>
                </tr>
            </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Total Amount -->
        <div class="total-amount">
            <p><strong>Total Amount:</strong>${totalAmount}</p>
           
        
        </div>

        <!-- Create Invoice Form -->
        <div class="invoice-form">
            <h3>Create Invoice</h3>
            <form action="createInvoice" method="post">
                <label for="user">Select User:</label>
                 <select id="user" name="user" required>
            <c:forEach items="${userlogin}" var="u">
                <option value="${u.userId}" selected>${u.username}</option>
            </c:forEach>
        </select>
                

                <label for="invoiceNumber">Invoice Number:</label>
                <input type="text" id="invoiceNumber" name="invoiceNumber" required>

                <label for="issueDate">Issue Date:</label>
                <input type="date" id="issueDate" name="issueDate" required>

                <label for="dueDate">Due Date:</label>
                <input type="date" id="dueDate" name="dueDate" required>

                <button type="submit">Create Invoice</button>
                <input type="hidden" id="totalAmount" name="totalAmount" value="${totalAmount}" />
            </form>
        </div>
    </div>
</body>
</html>