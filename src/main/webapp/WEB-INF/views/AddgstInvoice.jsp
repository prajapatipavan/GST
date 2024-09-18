<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create GST Invoice</title>
</head>
<body>
    <h1>Create New GST Invoice</h1>
    <form action="createInvoice" method="post">
        <label for="transaction">Transaction:</label>
        <select id="transaction" name="transaction" required>
            <c:forEach items="${transactions}" var="transaction">
                <option value="${transaction.id}">${transaction.gstNumber}</option>
            </c:forEach>
        </select><br/><br/>

        <label for="invoiceNumber">Invoice Number:</label>
        <input type="text" id="invoiceNumber" name="invoiceNumber" required /><br/><br/>

        <label for="issueDate">Issue Date:</label>
        <input type="date" id="issueDate" name="issueDate" required /><br/><br/>

        <label for="dueDate">Due Date:</label>
        <input type="date" id="dueDate" name="dueDate" required /><br/><br/>

        <input type="submit" value="Create Invoice" />
    </form>
</body>
</html>
