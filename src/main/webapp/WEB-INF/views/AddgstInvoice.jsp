<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Invoice</title>
    <link rel="stylesheet" href="path/to/your/css/styles.css">
</head>
<body>
<h1>User Details</h1>



    <p><strong>User ID:</strong> ${userd.userId}</p>
    <p><strong>Username:</strong> ${userd.username}</p>
    <p><strong>Email:</strong> ${userd.email}</p>
   


<h1>Select Transactions for Invoice</h1>

<form id="invoiceForm" action="createInvoice" method="post">
    <table>
        <thead>
            <tr>
                <th>Select</th>
                <th>Transaction ID</th>
                <th>GST Rate</th>
                <th>Amount</th>
                <th>GST Number</th>
                <th>Date</th>
                <th>Total Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="totalAmount" value="0.0" />
            <c:forEach var="transaction" items="${transactions}">
                <tr>
                    <td>
                        <input type="checkbox" name="selectedTransactions" value="${transaction.transactionId}" 
                               onclick="updateTotalAmount(${transaction.totalAmount})" />
                    </td>
                    <td>${transaction.transactionId}</td>
                    <td>${transaction.gstrate.rate}</td>
                    <td>${transaction.amount}</td>
                    <td>${transaction.gstNumber}</td>
                    <td>${transaction.date}</td>
                    <td>${transaction.totalAmount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2>Total Amount: <span id="totalAmountDisplay">0.00</span></h2>

    <h2>Invoice Details</h2>
    <label for="invoiceNumber">Invoice Number:</label>
    <input type="text" id="invoiceNumber" name="invoiceNumber" required />
    <br />
    <label for="issueDate">Issue Date:</label>
    <input type="date" id="issueDate" name="issueDate" required />
    <br />
    <label for="dueDate">Due Date:</label>
    <input type="date" id="dueDate" name="dueDate" required />
    <br />
    <button type="submit">Create Invoice</button>
</form>

<!-- Thank You Message -->
<div id="thankYouMessage" style="display:none;">
    <h2>Thank You for Your Business!</h2>
</div>

<script>
    let totalAmount = 0.0;

    function updateTotalAmount(transactionTotal) {
        // Update the total amount based on selected transactions
        totalAmount += transactionTotal;
        document.getElementById('totalAmountDisplay').innerText = totalAmount.toFixed(2);
    }

    // Optionally, handle form submission to clear total amount
    document.getElementById('invoiceForm').onsubmit = function() {
        document.getElementById('thankYouMessage').style.display = 'block';
    };
</script>

</body>
</html>
